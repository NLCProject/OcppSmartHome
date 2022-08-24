package org.ocpp.smart.home.services.init.interfaces

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

/**
 *
 */
interface IClientOnStartService {

    /**
     *
     */
    @EventListener(ApplicationReadyEvent::class)
    fun startServer()
}
