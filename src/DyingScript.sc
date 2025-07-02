;;; Sierra Script 1.0 - (do not remove this comment)
(script# 40)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DCIcon)
(use Cycle)
(use Obj)

(public
	DyingScript 0
)

(instance DyingScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 133])
		(asm
			lap      newState
			aTop     state
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_0048
			pushi    0
			callb    proc0_3,  0
			pushi    #fade
			pushi    0
			lag      gTheMusic
			send     4
			pushi    #setScript
			pushi    1
			pushi    0
			lag      global2
			send     6
			ldi      1002
			sag      gGNumber_2
			pushi    2
			pushi    132
			pushi    2
			callk    Load,  4
			ldi      3
			aTop     seconds
			jmp      code_0119
code_0048:
			dup     
			ldi      1
			eq?     
			bnt      code_0119
			pushi    2
			pushi    128
			pTos     caller
			callk    Load,  4
			pushi    #stop
			pushi    0
			lag      gTheSoundFX
			send     4
			pushi    #number
			pushi    1
			pushi    2
			pushi    6
			pushi    1
			pushi    1
			pushi    63
			pushi    1
			pushi    65535
			pushi    42
			pushi    0
			lag      gTheMusic
			send     22
			pushi    #view
			pushi    1
			pTos     caller
			lofsa    deadIcon
			send     6
			pushi    13
			pTos     register
			pushi    80
			pTos     next
			pushi    33
			lsg      global26
			pushi    82
			lofss    deadIcon
			pushi    81
			lofss    {Seguir Enfangado}
			pushi    0
			pushi    81
			lofss    {Comprar Pistas}
			pushi    1
			calle    proc255_0,  26
			bnt      code_00ba
			pushi    2
			pushi    40
			pushi    0
			calle    proc255_0,  4
code_00ba:
			ldi      1
			bnt      code_0119
			pushi    15
			pushi    40
			pushi    1
			pushi    80
			lofss    {Al dice:}
			pushi    33
			lsg      global26
			pushi    81
			lofss    {Cargar}
			pushi    1
			pushi    81
			lofss    {Reiniciar}
			pushi    2
			pushi    81
			lofss    {Salir}
			pushi    3
			calle    proc255_0,  30
			push    
			dup     
			ldi      1
			eq?     
			bnt      code_00f9
			pushi    #restore
			pushi    0
			lag      gGame
			send     4
			jmp      code_0116
code_00f9:
			dup     
			ldi      2
			eq?     
			bnt      code_010a
			pushi    #restart
			pushi    0
			lag      gGame
			send     4
			jmp      code_0116
code_010a:
			dup     
			ldi      3
			eq?     
			bnt      code_0116
			ldi      1
			sag      global4
			jmp      code_0119
code_0116:
			toss    
			jmp      code_00ba
code_0119:
			toss    
			ret     
		)
	)
)

(instance deadIcon of DCIcon
	(properties)
	
	(method (init)
		(super init:)
		(if (== gNumber 540)
			((= cycler (End new:)) init: self)
		)
	)
)
