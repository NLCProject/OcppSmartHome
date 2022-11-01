package org.ocpp.smart.home.services.authorize.interfaces

import org.ocpp.smart.home.events.ClientRegisteredEvent
import org.springframework.context.event.EventListener

/**
 * Authorization service.
 */
interface IAuthorizationService {

    /**
     * Authorize at available OCPP server instance on start up.
     */
    @EventListener(ClientRegisteredEvent::class)
    fun authorize()
}
