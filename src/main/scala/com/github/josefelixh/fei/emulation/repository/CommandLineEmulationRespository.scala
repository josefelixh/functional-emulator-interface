package com.github.josefelixh.fei.emulation.repository

import com.github.josefelixh.fei.emulation._
import com.github.josefelixh.fei.model._

object CommandLineEmulationRespository extends EmulationRepository[CommandLineEmulationInput, CommandLineEmulationOutput] {

  override def get(input: CommandLineEmulationInput): Option[CommandLineEmulationOutput] = {
    Option(new CommandLineEmulationOutput(Array()))
  }
  
  override def put(input: CommandLineEmulationInput, output: CommandLineEmulationOutput): Unit = {
    
  }
}
