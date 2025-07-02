;;; Sierra Script 1.0 - (do not remove this comment)
(script# 996)
(include sci.sh)
(use Main)
(use Class_255_0)
(use n984)
(use Sound)
(use Cycle)
(use TheMenuBar)
(use Feature)
(use Obj)


(local
	[local0 23]
	local23
)
(class User of Obj
	(properties
		alterEgo 0
		canInput 0
		controls 0
		echo 32
		prevDir 0
		prompt {Introduce orden}
		inputLineAddr 0
		x -1
		y -1
		blocks 1
		mapKeyToDir 1
		curEvent 0
	)
	
	(method (init param1 param2)
		(= inputLineAddr (if argc param1 else @local0))
		(= local23 (if (== argc 2) param2 else 45))
		(= curEvent uEvt)
	)
	
	(method (doit)
		(if (== 0 global55)
			(curEvent
				type: 0
				message: 0
				modifiers: 0
				y: 0
				x: 0
				claimed: 0
			)
			(GetEvent 32767 curEvent)
			(self handleEvent: curEvent)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(asm
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			bnt      code_0130
			lap      pEvent
			sag      global24
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			sat      temp0
			pToa     mapKeyToDir
			bnt      code_007f
			pushi    1
			lsp      pEvent
			callk    MapKeyToDir,  2
code_007f:
			class    TheMenuBar
			bnt      code_0083
code_0083:
			pushi    1
			lsp      pEvent
			callk    GlobalToLocal,  2
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			not     
			bnt      code_00a1
			pushi    #handleEvent
			pushi    2
			lsp      pEvent
			lst      temp0
			lag      gGame
			send     8
code_00a1:
			pToa     controls
			bnt      code_00c6
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			not     
			bnt      code_00c6
			pushi    #contains
			pushi    1
			pTos     alterEgo
			lag      gCast
			send     6
			bnt      code_00c6
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			pToa     alterEgo
			send     6
code_00c6:
			pToa     canInput
			bnt      code_0130
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			not     
			bnt      code_0130
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      4
			eq?     
			bnt      code_0130
			pushi    #message
			pushi    0
			lap      pEvent
			send     4
			push    
			pToa     echo
			eq?     
			bt       code_0105
			pushi    32
			pushi    #message
			pushi    0
			lap      pEvent
			send     4
			le?     
			bnt      code_0103
			pprev   
			ldi      255
			le?     
code_0103:
			bnt      code_0130
code_0105:
			pushi    #getInput
			pushi    1
			lsp      pEvent
			self     6
			bnt      code_0130
			pushi    2
			lea      @local0
			push    
			lsp      pEvent
			callk    Parse,  4
			bnt      code_0130
			pushi    #type
			pushi    1
			pushi    128
			lap      pEvent
			send     6
			pushi    #said
			pushi    1
			lsp      pEvent
			self     6
code_0130:
			ldi      0
			sag      global24
			ret     
		)
	)
	
	(method (getInput param1 &tmp temp0 temp1)
		(if (!= (param1 type?) 4) (= local0 0))
		(if (!= (param1 message?) echo)
			(Format @local0 996 0 (param1 message?))
		)
		(= temp0 (Sound pause: blocks))
		(= temp1 (proc255_2 @local0 local23 prompt 67 x y))
		(Sound pause: temp0)
		(return temp1)
	)
	
	(method (canControl theControls)
		(if argc (= controls theControls) (= prevDir 0))
		(return controls)
	)
	
	(method (said param1)
		(if global54
			(proc984_0 alterEgo gSFeatures gCast gFeatures)
		else
			(gSFeatures add: gCast gFeatures)
		)
		(if TheMenuBar (gSFeatures addToFront: TheMenuBar))
		(gSFeatures addToEnd: gGame handleEvent: param1 release:)
		(if
		(and (== (param1 type?) 128) (not (param1 claimed?)))
			(gGame pragmaFail: @local0)
		)
	)
)

(class Ego of Act
	(properties
		y 0
		x 0
		z 0
		heading 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $2000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		cycleSpeed 0
		script 0
		cycler 0
		timer 0
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 0
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		edgeHit 0
	)
	
	(method (init)
		(super init:)
		(if (not cycler) (self setCycle: Walk))
	)
	
	(method (doit)
		(super doit:)
		(= edgeHit
			(cond 
				((<= x 0) 4)
				((<= y (global2 horizon?)) 1)
				((>= x 319) 2)
				((>= y 189) 3)
				(else 0)
			)
		)
	)
	
	(method (get param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			((gInv at: [param1 temp0]) moveTo: self)
			(++ temp0)
		)
	)
	
	(method (put param1 param2)
		(if (self has: param1)
			((gInv at: param1)
				moveTo: (if (== argc 1) -1 else param2)
			)
		)
	)
	
	(method (has param1 &tmp temp0)
		(= temp0 (gInv at: param1))
		(return (if (and temp0 (temp0 ownedBy: self)) 1 else 0))
	)
	
	(method (handleEvent pEvent &tmp pEventMessage)
		(if (not (super handleEvent: pEvent))
			(switch (pEvent type?)
				(evMOUSEBUTTON
					(if
						(and
							(not (& (pEvent modifiers?) emSHIFT))
							(User controls?)
						)
						(self setMotion: MoveTo (pEvent x?) (pEvent y?))
						(User prevDir: 0)
						(pEvent claimed: 1)
					)
				)
				(evJOYSTICK
					(= pEventMessage (pEvent message?))
					(if
						(and
							(== pEventMessage (User prevDir?))
							(IsObject mover)
						)
						(= pEventMessage 0)
					)
					(User prevDir: pEventMessage)
					(self setDirection: pEventMessage)
					(pEvent claimed: 1)
				)
			)
		)
		(pEvent claimed?)
	)
)

(instance uEvt of Event
	(properties)
)
