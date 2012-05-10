package com.github.josefelixh.fei

import com.github.josefelixh.fei.model._


abstract class Emulation[INPUT <: Input,  OUTPUT <: Output] {
	def emulate(input: INPUT): OUTPUT
}
