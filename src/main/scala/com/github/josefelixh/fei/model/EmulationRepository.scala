package com.github.josefelixh.fei.model

import com.github.josefelixh.fei.emulation.CommandLineEmulationInput
import com.github.josefelixh.fei.emulation.CommandLineEmulationOutput

abstract class EmulationRepository[IN <: Input, OUT <: Output] {
	def put(input: IN, output: OUT): Unit
  def get(input: CommandLineEmulationInput): Option[CommandLineEmulationOutput]
}