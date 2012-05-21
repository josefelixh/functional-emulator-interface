package com.github.josefelixh.fei.model
import java.io.{FileInputStream, File}
import java.io.ObjectInputStream

trait Player[IN <: Input, OUT <: Output] {

  def play(input: IN): Option[OUT] = {
    playFile(new File(input.ident + ".ser"))
  }
  
  private def playFile(file: File): Option[OUT] = file.exists() match {
    case true => Option(deserialize(file).output)
    case false => None
  }
  
  private def deserialize(file: File): Recording[IN, OUT] = {
    val fis = new FileInputStream(file)
    val ois = new ObjectInputStream(fis)
    ois.readObject().asInstanceOf[Recording[IN, OUT]]
  }
}