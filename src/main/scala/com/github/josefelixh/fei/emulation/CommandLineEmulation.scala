package com.github.josefelixh.fei.emulation

import com.github.josefelixh.fei.model._
import com.github.josefelixh.fei.emulation.{
  CommandLineEmulationInput => In,
  CommandLineEmulationOutput => Out
}
import com.github.josefelixh.fei.emulation.repository.{
  CommandLineEmulationRespository => Repository
}

object CommandLineEmulation {
  
  def apply(input: In) = {
    new CommandLineEmulation().emulate(input)
  }
}

class CommandLineEmulation extends Emulation[In, Out] {
  
  def emulate(input: In) = {
    val recordedOutput = Repository.get(input)
    
    if (recordedOutput != null) {
      learnEmulation(input) {input: In =>
        retrieve(input)
      }
    } else {
      recordedOutput
    }
     
  }
  
  def learnEmulation(input: In)(f: (In => Out)) = {
    f.apply(input)
  }
  
  def retrieve(input: In): Out = {
    val commandUnderEmulation = input.args(0)
    val commandArguments = input.args diff commandUnderEmulation
    new Out(commandLineOutput(commandUnderEmulation, commandArguments))
  }
  
  def commandLineOutput(command: String, args: Array[String]) = command match {
		case "ping" => Array(pingLocalhostEmulationOutput)
  }
  
  val pingLocalhostEmulationOutput = 
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

case class CommandLineEmulationInput(val args: Array[String]) extends Input {
  override def ident = {
    args.mkString("=!=")
  }
}

case class CommandLineEmulationOutput(private val output: Array[String]) extends Output {
  override def toString() = {
   output.mkString(" ")
  }
}