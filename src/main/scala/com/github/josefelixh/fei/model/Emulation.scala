package com.github.josefelixh.fei.model

abstract class Emulation[INPUT <: Input,  OUTPUT <: Output] {
	def emulate(input: INPUT): OUTPUT
}
