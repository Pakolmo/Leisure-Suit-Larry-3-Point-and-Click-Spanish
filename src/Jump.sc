;;; Sierra Script 1.0 - (do not remove this comment)
(script# 991)
(include sci.sh)
(use Main)
(use Cycle)


(class Jump of Motion
	(properties
		client 0
		caller 0
		x 20000
		y 20000
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		gx 0
		gy 3
		xStep 20000
		yStep 0
		signal $0000
		illegalBits $0000
		waitApogeeX 1
		waitApogeeY 1
	)
	
	(method (init param1 param2 &tmp temp0)
		(asm
			lap      param1
			aTop     client
			lsp      argc
			ldi      2
			eq?     
			bnt      code_0015
			lap      param2
			aTop     caller
code_0015:
			pushi    #illegalBits
			pushi    0
			pToa     client
			send     4
			aTop     illegalBits
			pushi    #signal
			pushi    0
			pToa     client
			send     4
			aTop     signal
			pushi    #illegalBits
			pushi    1
			pushi    0
			pushi    66
			pushi    0
			pToa     client
			send     10
			pTos     xStep
			ldi      20000
			eq?     
			bnt      code_0088
			pushi    #heading
			pushi    0
			pToa     client
			send     4
			sat      temp0
			lst      temp0
			ldi      330
			gt?     
			bt       code_0067
			lst      temp0
			ldi      30
			lt?     
			bt       code_0067
			pushi    150
			lat      temp0
			lt?     
			bnt      code_0065
			pprev   
			ldi      210
			lt?     
code_0065:
			bnt      code_006b
code_0067:
			ldi      0
			jmp      code_0086
code_006b:
			lst      temp0
			ldi      180
			lt?     
			bnt      code_007d
			pushi    #xStep
			pushi    0
			pToa     client
			send     4
			jmp      code_0086
code_007d:
			pushi    #xStep
			pushi    0
			pToa     client
			send     4
			neg     
code_0086:
			aTop     xStep
code_0088:
			pToa     waitApogeeX
			bnt      code_0099
			pTos     xStep
			pToa     gx
			mul     
			push    
			ldi      0
			lt?     
			bnt      code_0099
			ldi      1
code_0099:
			not     
			bnt      code_00a0
			ldi      0
			aTop     waitApogeeX
code_00a0:
			pToa     waitApogeeY
			bnt      code_00b1
			pTos     yStep
			pToa     gy
			mul     
			push    
			ldi      0
			lt?     
			bnt      code_00b1
			ldi      1
code_00b1:
			not     
			bnt      code_00b8
			ldi      0
			aTop     waitApogeeY
code_00b8:
			pushi    #setTest
			pushi    0
			self     4
			ret     
		)
	)
	
	(method (doit &tmp theXStep theYStep)
		(= xLast (client x?))
		(= yLast (client y?))
		(client x: (+ xLast xStep) y: (+ yLast yStep))
		(= theXStep xStep)
		(= theYStep yStep)
		(= xStep (+ xStep gx))
		(= yStep (+ yStep gy))
		(if
			(and
				(not waitApogeeX)
				(!= x 20000)
				(<= 0 (* dx (- (client x?) x)))
			)
			(client x: x)
			(self moveDone:)
			(return)
		)
		(if
			(and
				(not waitApogeeY)
				(!= y 20000)
				(<= 0 (* dy (- (client y?) y)))
			)
			(client y: y)
			(self moveDone:)
			(return)
		)
		(if (<= (* theXStep xStep) 0)
			(= waitApogeeX 0)
			(self setTest:)
		)
		(if (<= (* theYStep yStep) 0)
			(= waitApogeeY 0)
			(self setTest:)
		)
	)
	
	(method (moveDone)
		(client illegalBits: illegalBits signal: signal)
		(if caller (= global58 1) (= completed 1))
	)
	
	(method (setTest)
		(= dx
			(if
				(or
					(> (client x?) x)
					(and (== (client x?) x) (> xStep 0))
				)
				-1
			else
				1
			)
		)
		(= dy
			(if
				(or
					(> (client y?) y)
					(and (== (client y?) y) (> yStep 0))
				)
				-1
			else
				1
			)
		)
	)
	
	(method (motionCue)
		(client mover: 0)
		(if (and completed (IsObject caller)) (caller cue:))
		(self dispose:)
	)
)

(class JumpTo of Jump
	(properties
		client 0
		caller 0
		x 20000
		y 20000
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		gx 0
		gy 3
		xStep 20000
		yStep 0
		signal $0000
		illegalBits $0000
		waitApogeeX 1
		waitApogeeY 1
	)
	
	(method (init theClient theX theY param4 &tmp temp0 temp1 [temp2 52])
		(= client theClient)
		(= x theX)
		(= y theY)
		(if
		(and (== x (theClient x?)) (== y (theClient y?)))
			(= illegalBits (client illegalBits?))
			(= signal (client signal?))
			(self moveDone:)
			(return)
		)
		(= temp0 (- x (theClient x?)))
		(= temp1 (- y (theClient y?)))
		(SetJump self temp0 temp1 gy)
		(if (not temp0) (= x 20000))
		(if (not temp1) (= y 20000))
		(switch argc
			(3 (super init: theClient))
			(4
				(super init: theClient param4)
			)
		)
	)
	
	(method (moveDone)
		(if (!= x 20000) (client x: x))
		(if (!= y 20000) (client y: y))
		(super moveDone:)
	)
)
