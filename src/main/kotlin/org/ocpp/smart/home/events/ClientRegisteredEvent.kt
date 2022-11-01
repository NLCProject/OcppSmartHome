package org.ocpp.smart.home.events

import org.springframework.context.ApplicationEvent

/**
 * Client registered event.
 */
class ClientRegisteredEvent(source: Any) : ApplicationEvent(source)
