package org.ocpp.smart.home.events

import org.springframework.context.ApplicationEvent

/**
 * Client authorized event.
 */
class ClientAuthorizedEvent(source: Any) : ApplicationEvent(source)
