package org.ocpp.smart.home.services.modbus.interfaces

import org.ocpp.smart.home.events.ClientAuthorizedEvent
import org.springframework.context.event.EventListener

/**
 *
 */
interface IServerModbusConnectorService {

    /**
     *
     */
    @EventListener(ClientAuthorizedEvent::class)
    fun sendAvailableCommandsOnInit()
}
