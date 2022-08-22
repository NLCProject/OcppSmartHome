package org.ocpp.smart.home.services.authorize.interfaces

import org.ocpp.smart.home.events.ClientRegisteredEvent
import org.springframework.context.event.EventListener

/**
 *
 */
interface IAuthorizationService {

    /**
     *
     */
    @EventListener(ClientRegisteredEvent::class)
    fun authorize()
}
