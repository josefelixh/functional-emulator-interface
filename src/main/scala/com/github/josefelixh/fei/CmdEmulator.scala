package com.github.josefelixh.fei

import com.github.josefelixh.fei.emulation._
import com.github.josefelixh.fei.model.Recorder
import com.github.josefelixh.fei.emulation.repository.CommandLineEmulationRespository
import com.github.josefelixh.fei.model.Player

object CmdEmulator
	extends Player[CommandLineEmulationInput, CommandLineEmulationOutput]
		with Recorder[CommandLineEmulationInput, CommandLineEmulationOutput] {
  
  def main(args: Array[String]) {
    def input = new CommandLineEmulationInput(args)
    
    def output = CommandLineEmulation(input)
    record(input) {input: CommandLineEmulationInput =>
      output
    }
    
    play(input) match {
      case Some(output) => println(output)
      case None => println("No recording found")
    }
  }
}