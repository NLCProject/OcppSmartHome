package org.ocpp.smart.home.services.batteryController.interfaces

import org.ocpp.smart.home.events.ClientRegisteredEvent
import org.springframework.context.event.EventListener

/**
 *
 */
interface IBatteryControllerInitService {

    /**
     *
     */
    @EventListener(ClientRegisteredEvent::class)
    fun authorize()
}
