package com.github.josefelixh.fei.emulation
import com.github.josefelixh.fei.Emulation
import com.github.josefelixh.fei.model.Input
import com.github.josefelixh.fei.model.Output


object CommandLineEmulation extends Emulation[CommandLineEmulationInput, CommandLineEmulationOutput] {
  
  override def emulate(input: CommandLineEmulationInput): CommandLineEmulationOutput = {
    def commandUnderEmulation = input.args(0)
    def commandArguments = input.args.filter { arg => commandUnderEmulation != arg }
    
    def commandLineOutput(command: String, args: Array[String]) = command match {
      case "ping" => Array(pingLocalhostEmulationOutput)
    }
    new CommandLineEmulationOutput(commandLineOutput(commandUnderEmulation, commandArguments))
  }
  
  def pingLocalhostEmulationOutput = 
    "\n" + """
    |PING localhost (127.0.0.1) 56(84) bytes of data.
		|64 bytes from localhost (127.0.0.1): icmp_req=1 ttl=64 time=0.075 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=2 ttl=64 time=0.097 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=3 ttl=64 time=0.094 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=4 ttl=64 time=0.094 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=5 ttl=64 time=0.098 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=6 ttl=64 time=0.092 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=7 ttl=64 time=0.115 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=8 ttl=64 time=0.093 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=9 ttl=64 time=0.094 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=10 ttl=64 time=0.122 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=11 ttl=64 time=0.093 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=12 ttl=64 time=0.093 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=13 ttl=64 time=0.096 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=14 ttl=64 time=0.094 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=15 ttl=64 time=0.124 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=16 ttl=64 time=0.123 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=17 ttl=64 time=0.096 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=18 ttl=64 time=0.120 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=19 ttl=64 time=0.097 ms
		|64 bytes from localhost (127.0.0.1): icmp_req=20 ttl=64 time=0.093 ms
    """.stripMargin
}

case class CommandLineEmulationInput(val args: Array[String]) extends Input

case class CommandLineEmulationOutput(private val output: Array[String]) extends Output {
  override def toString() = {
   output.foldLeft("")(_+ " " +_)
  }
} 