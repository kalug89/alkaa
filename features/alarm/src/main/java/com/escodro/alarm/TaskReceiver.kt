package com.escodro.alarm

import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.escodro.domain.usecase.alarm.RescheduleFutureAlarms
import com.escodro.domain.usecase.alarm.ShowAlarm
import com.escodro.domain.usecase.alarm.SnoozeAlarm
import com.escodro.domain.usecase.task.CompleteTask
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mu.KLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * [BroadcastReceiver] to be notified by the [android.app.AlarmManager].
 */
internal class TaskReceiver : BroadcastReceiver(), KoinComponent {

    private val completeTaskUseCase: CompleteTask by inject()

    private val showAlarmUseCase: ShowAlarm by inject()

    private val snoozeAlarmUseCase: SnoozeAlarm by inject()

    private val rescheduleUseCase: RescheduleFutureAlarms by inject()

    @Suppress("GlobalCoroutineUsage")
    override fun onReceive(context: Context?, intent: Intent?) {
        logger.debug("onReceive() - intent ${intent?.action}")

        GlobalScope.launch {
            handleIntent(intent)
        }
    }

    private suspend fun handleIntent(intent: Intent?) =
        when (intent?.action) {
            ALARM_ACTION -> getTaskId(intent)?.let { showAlarmUseCase(it) }
            COMPLETE_ACTION -> getTaskId(intent)?.let { completeTaskUseCase(it) }
            SNOOZE_ACTION -> getTaskId(intent)?.let { snoozeAlarmUseCase(it) }
            Intent.ACTION_BOOT_COMPLETED,
            AlarmManager.ACTION_SCHEDULE_EXACT_ALARM_PERMISSION_STATE_CHANGED -> rescheduleUseCase()
            else -> logger.error("Action not supported")
        }

    private fun getTaskId(intent: Intent?) = intent?.getLongExtra(EXTRA_TASK, 0)

    companion object : KLogging() {

        const val EXTRA_TASK = "extra_task"

        const val ALARM_ACTION = "com.escodro.alkaa.SET_ALARM"

        const val COMPLETE_ACTION = "com.escodro.alkaa.SET_COMPLETE"

        const val SNOOZE_ACTION = "com.escodro.alkaa.SNOOZE"
    }
}
