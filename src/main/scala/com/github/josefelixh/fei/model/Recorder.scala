package com.github.josefelixh.fei.model

import com.github.josefelixh.fei.emulation.CommandLineEmulation
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing

trait Recorder[
  IN <: Input,
  OUT <: Output
  ] {
  
  def record(input: IN)(f: (IN => OUT)) = {
    println("Recording started...")
    val output= f.apply(input)
    
    val fos = new FileOutputStream(input.ident + ".ser")
    val oos = new ObjectOutputStream(fos)
    oos.writeObject(new Recording(input, output))
    oos.close()
    
    println("Recording finished...")
  }
}

case class Recording[IN <: Input, OUT <: Output](val input: IN, val output: OUT)