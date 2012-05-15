package com.github.josefelixh.fei

import com.github.josefelixh.fei.emulation._

object CmdEmulator {
  
  def main(args: Array[String]) {
    def input = new CommandLineEmulationInput(args)
    def output = CommandLineEmulation emulate input
    println(output)
  }
  
  
}