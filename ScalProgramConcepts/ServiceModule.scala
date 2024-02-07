package abiP

import com.softwaremill.macwire.wire

trait ServiceModule {
  lazy val dependency: Dependency = wire[RealDependency]
  lazy val service: Service = wire[Service]
}