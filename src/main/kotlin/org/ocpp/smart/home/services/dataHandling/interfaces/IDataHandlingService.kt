package org.ocpp.smart.home.services.dataHandling.interfaces

import org.ocpp.client.event.client.request.ClientDataTransferRequestEvent
import org.springframework.context.event.EventListener

/**
 * Data handling service.
 */
interface IDataHandlingService {

    /**
     * Incoming data.
     *
     * @param event .
     */
    @EventListener(ClientDataTransferRequestEvent::class)
    fun handleIncomingDataTransfer(event: ClientDataTransferRequestEvent)
}
