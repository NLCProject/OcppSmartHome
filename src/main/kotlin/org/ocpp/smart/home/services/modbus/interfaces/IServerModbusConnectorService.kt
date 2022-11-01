package org.ocpp.smart.home.services.modbus.interfaces

import org.ocpp.smart.home.events.ClientAuthorizedEvent
import org.springframework.context.event.EventListener

/**
 * Service to send all available Modbus commands to the registered OCPP server on start up.
 */
interface IServerModbusConnectorService {

    /**
     * Send all available Modbus commands to the registered OCPP server on start up.
     */
    @EventListener(ClientAuthorizedEvent::class)
    fun sendAvailableCommandsOnInit()
}
