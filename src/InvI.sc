;;; Sierra Script 1.0 - (do not remove this comment)
(script# 995)
(include sci.sh)
(use Main)
(use Class_255_0)
(use SysWindow)
(use Obj)


(local
	newDButton_3
	newDButton
	newDButton_2
	[local3 56]
)
(class InvI of Obj
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
	)
	
	(method (saidMe)
		(Said said)
	)
	
	(method (ownedBy param1)
		(return (== owner param1))
	)
	
	(method (moveTo theOwner)
		(= owner theOwner)
		(return self)
	)
	
	(method (showSelf)
		(proc255_1
			(if description description else name)
			view
			loop
			cel
		)
	)
	
	(method (changeState newState)
		(if script (script changeState: newState))
	)
)

(class Inv of Set
	(properties
		elements 0
		size 0
		carrying {Est*s llevando:}
		empty {^No llevas nada!}
	)
	
	(method (init)
		(= gInv self)
	)
	
	(method (saidMe)
		(self firstTrue: #saidMe)
	)
	
	(method (ownedBy param1)
		(self firstTrue: #ownedBy param1)
	)
	
	(method (showSelf param1)
		(invD text: carrying doit: param1)
	)
)

(instance invD of Dialog
	(properties)
	
	(method (init param1 &tmp temp0 temp1 temp2 temp3 newDText gInvFirst temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(= temp6 (NodeValue gInvFirst))
			(if (temp6 ownedBy: param1)
				(++ temp3)
				(self
					add:
						((= newDText (DText new:))
							value: temp6
							text: (temp6 name?)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: global23
							setSize:
							yourself:
						)
				)
				(if
				(< temp2 (- (newDText nsRight?) (newDText nsLeft?)))
					(= temp2 (- (newDText nsRight?) (newDText nsLeft?)))
				)
				(= temp1
					(+ temp1 (- (newDText nsBottom?) (newDText nsTop?)) 1)
				)
				(if (> temp1 140)
					(= temp1 4)
					(= temp0 (+ temp0 temp2 10))
					(= temp2 0)
				)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(if (not temp3) (self dispose:) (return 0))
		(= window SysWindow)
		(self setSize:)
		(= newDButton (DButton new:))
		(newDButton
			text: {Elegir}
			setSize:
			moveTo: (+ nsLeft 4 (newDButton nsLeft?)) nsBottom
		)
		(= newDButton_2 (DButton new:))
		(newDButton_2
			text: {Mirar_}
			setSize:
			moveTo: (+ nsLeft 4 (newDButton nsRight?)) nsBottom
		)
		(= newDButton_3 (DButton new:))
		(newDButton_3
			text: {OK}
			setSize:
			moveTo: (+ nsLeft 4 (newDButton_2 nsRight?)) nsBottom
		)
		(self
			add: newDButton newDButton_2 newDButton_3
			setSize:
			center:
		)
		(return temp3)
	)
	
	(method (doit param1 &tmp temp0)
		(asm
			pushi    #init
			pushi    1
			lsp      param1
			self     6
			not     
			bnt      code_020d
			pushi    1
			pushi    #empty
			pushi    0
			lag      gInv
			send     4
			push    
			calle    proc255_0,  2
			ret     
code_020d:
			pushi    #open
			pushi    2
			pushi    4
			pushi    15
			self     8
			lal      newDButton_3
			sat      temp0
			pushi    #setCursor
			pushi    1
			pushi    993
			lag      gGame
			send     6
code_0228:
			ldi      1
			bnt      code_0725
			pushi    #doit
			pushi    1
			lst      temp0
			super    Dialog,  6
			sat      temp0
			lat      temp0
			not     
			bt       code_024b
			lst      temp0
			ldi      65535
			eq?     
			bt       code_024b
			lst      temp0
			lal      newDButton_3
			eq?     
			bnt      code_025b
code_024b:
			lsg      gCursorNumber
			ldi      993
			eq?     
			bnt      code_0258
			ldi      999
			sag      gCursorNumber
code_0258:
			jmp      code_0725
code_025b:
			lst      temp0
			lal      newDButton
			eq?     
			bt       code_0270
			lst      temp0
			lal      newDButton_2
			eq?     
			bt       code_0270
			lst      temp0
			lal      newDButton_3
			eq?     
			bnt      code_02ad
code_0270:
			lst      temp0
			lal      newDButton
			eq?     
			bnt      code_028d
			lsg      gCursorNumber
			ldi      993
			ne?     
			bnt      code_028b
			pushi    #setCursor
			pushi    1
			pushi    993
			lag      gGame
			send     6
code_028b:
			jmp      code_02aa
code_028d:
			lst      temp0
			lal      newDButton_2
			eq?     
			bnt      code_02aa
			lsg      gCursorNumber
			ldi      998
			ne?     
			bnt      code_02a8
			pushi    #setCursor
			pushi    1
			pushi    998
			lag      gGame
			send     6
code_02a8:
			jmp      code_02aa
code_02aa:
			jmp      code_0722
code_02ad:
			lsg      gCursorNumber
			dup     
			ldi      993
			eq?     
			bnt      code_02e2
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			sag      gGCursorNumber
			pushi    #setCursor
			pushi    1
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			lag      gGame
			send     6
			jmp      code_0721
code_02e2:
			dup     
			ldi      998
			eq?     
			bnt      code_033f
			pushi    10
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			eq?     
			bnt      code_032e
			pushi    #has
			pushi    1
			pushi    9
			lag      gEgo
			send     6
			not     
			bnt      code_032e
			pushi    #get
			pushi    1
			pushi    9
			lag      gEgo
			send     6
			pushi    #changeScore
			pushi    1
			pushi    100
			lag      gGame
			send     6
			pushi    2
			pushi    0
			pushi    42
			calle    proc255_0,  4
			jmp      code_033c
code_032e:
			pushi    #showSelf
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
code_033c:
			jmp      code_0721
code_033f:
			dup     
			ldi      19
			eq?     
			bnt      code_0419
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      16
			eq?     
			bnt      code_0416
			pushi    #has
			pushi    1
			pushi    16
			lag      gEgo
			send     6
			not     
			bnt      code_0379
			pushi    2
			pushi    540
			pushi    9
			calle    proc255_0,  4
			jmp      code_0416
code_0379:
			pushi    #has
			pushi    1
			pushi    19
			lag      gEgo
			send     6
			not     
			bnt      code_03b1
			pushi    2
			pushi    540
			pushi    10
			calle    proc255_0,  4
			lsg      global88
			ldi      3
			ge?     
			bnt      code_03af
			pushi    5
			pushi    540
			pushi    11
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
code_03af:
			jmp      code_0416
code_03b1:
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_03bf
			pushi    0
			callb    proc0_9,  0
			jmp      code_0416
code_03bf:
			pushi    1
			pushi    73
			callb    proc0_22,  2
			not     
			bnt      code_03ec
			pushi    2
			pushi    540
			pushi    12
			calle    proc255_0,  4
			pushi    5
			pushi    540
			pushi    13
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			jmp      code_0416
code_03ec:
			pushi    1
			pushi    74
			callb    proc0_22,  2
			bnt      code_0404
			pushi    2
			pushi    540
			pushi    14
			calle    proc255_0,  4
			jmp      code_0416
code_0404:
			pushi    #changeState
			pushi    1
			pushi    5
			pushi    2
			pushi    540
			pushi    1
			callk    ScriptID,  4
			send     6
code_0416:
			jmp      code_0721
code_0419:
			dup     
			ldi      16
			eq?     
			bnt      code_04f3
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      19
			eq?     
			bnt      code_04f0
			pushi    #has
			pushi    1
			pushi    16
			lag      gEgo
			send     6
			not     
			bnt      code_0453
			pushi    2
			pushi    540
			pushi    9
			calle    proc255_0,  4
			jmp      code_04f0
code_0453:
			pushi    #has
			pushi    1
			pushi    19
			lag      gEgo
			send     6
			not     
			bnt      code_048b
			pushi    2
			pushi    540
			pushi    10
			calle    proc255_0,  4
			lsg      global88
			ldi      3
			ge?     
			bnt      code_0489
			pushi    5
			pushi    540
			pushi    11
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
code_0489:
			jmp      code_04f0
code_048b:
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_0499
			pushi    0
			callb    proc0_9,  0
			jmp      code_04f0
code_0499:
			pushi    1
			pushi    73
			callb    proc0_22,  2
			not     
			bnt      code_04c6
			pushi    2
			pushi    540
			pushi    12
			calle    proc255_0,  4
			pushi    5
			pushi    540
			pushi    13
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			jmp      code_04f0
code_04c6:
			pushi    1
			pushi    74
			callb    proc0_22,  2
			bnt      code_04de
			pushi    2
			pushi    540
			pushi    14
			calle    proc255_0,  4
			jmp      code_04f0
code_04de:
			pushi    #changeState
			pushi    1
			pushi    5
			pushi    2
			pushi    540
			pushi    1
			callk    ScriptID,  4
			send     6
code_04f0:
			jmp      code_0721
code_04f3:
			dup     
			ldi      3
			eq?     
			bnt      code_0606
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      21
			eq?     
			bt       code_054b
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      22
			eq?     
			bt       code_054b
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      34
			eq?     
			bt       code_054b
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      2
			eq?     
			bnt      code_05f8
code_054b:
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      22
			eq?     
			bnt      code_056e
			pushi    2
			pushi    0
			pushi    28
			calle    proc255_0,  4
			jmp      code_05f6
code_056e:
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      34
			eq?     
			bnt      code_0590
			pushi    2
			pushi    0
			pushi    28
			calle    proc255_0,  4
			jmp      code_05f6
code_0590:
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      2
			eq?     
			bnt      code_05b2
			pushi    2
			pushi    0
			pushi    23
			calle    proc255_0,  4
			jmp      code_05f6
code_05b2:
			pushi    #has
			pushi    1
			pushi    2
			lag      gEgo
			send     6
			not     
			bnt      code_05ce
			pushi    2
			pushi    0
			pushi    22
			calle    proc255_0,  4
			jmp      code_05f6
code_05ce:
			lsg      gGNumber_2
			ldi      0
			eq?     
			bt       code_05dc
			lsg      gGNumber_2
			ldi      10
			eq?     
			bnt      code_05f1
code_05dc:
			pushi    #setScript
			pushi    1
			pushi    1
			pushi    43
			callk    ScriptID,  2
			push    
			lag      gGame
			send     6
			jmp      code_0725
			jmp      code_05f6
code_05f1:
			pushi    0
			callb    proc0_9,  0
code_05f6:
			jmp      code_0603
code_05f8:
			pushi    1
			lofss    {No puedes usar esos dos objetos juntos.}
			calle    proc255_0,  2
code_0603:
			jmp      code_0721
code_0606:
			dup     
			ldi      2
			eq?     
			bnt      code_063c
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      3
			eq?     
			bnt      code_062e
			pushi    2
			pushi    0
			pushi    23
			calle    proc255_0,  4
			jmp      code_0639
code_062e:
			pushi    1
			lofss    {No puedes usar esos dos objetos juntos.}
			calle    proc255_0,  2
code_0639:
			jmp      code_0721
code_063c:
			dup     
			ldi      21
			eq?     
			bnt      code_0716
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      3
			eq?     
			bt       code_0680
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      22
			eq?     
			bt       code_0680
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      34
			eq?     
			bnt      code_0709
code_0680:
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      22
			eq?     
			bnt      code_06a2
			pushi    2
			pushi    0
			pushi    28
			calle    proc255_0,  4
			jmp      code_0707
code_06a2:
			pushi    #view
			pushi    0
			pushi    #value
			pushi    0
			lat      temp0
			send     4
			send     4
			push    
			ldi      34
			eq?     
			bnt      code_06c4
			pushi    2
			pushi    0
			pushi    28
			calle    proc255_0,  4
			jmp      code_0707
code_06c4:
			pushi    #has
			pushi    1
			pushi    2
			lag      gEgo
			send     6
			not     
			bnt      code_06e0
			pushi    2
			pushi    0
			pushi    22
			calle    proc255_0,  4
			jmp      code_0707
code_06e0:
			lsg      gGNumber_2
			ldi      0
			eq?     
			bt       code_06ee
			lsg      gGNumber_2
			ldi      10
			eq?     
			bnt      code_0702
code_06ee:
			pushi    #setScript
			pushi    1
			pushi    1
			pushi    43
			callk    ScriptID,  2
			push    
			lag      gGame
			send     6
			jmp      code_0725
			jmp      code_0707
code_0702:
			pushi    0
			callb    proc0_9,  0
code_0707:
			jmp      code_0714
code_0709:
			pushi    1
			lofss    {No puedes usar esos dos objetos juntos.}
			calle    proc255_0,  2
code_0714:
			jmp      code_0721
code_0716:
			pushi    1
			lofss    {No puedes usar esos dos objetos juntos.}
			calle    proc255_0,  2
code_0721:
			toss    
code_0722:
			jmp      code_0228
code_0725:
			pushi    #dispose
			pushi    0
			self     4
			ret     
		)
	)
	
	(method (handleEvent pEvent &tmp pEventMessage pEventType)
		(= pEventMessage (pEvent message?))
		(= pEventType (pEvent type?))
		(switch pEventType
			(evKEYBOARD
				(switch pEventMessage
					(KEY_UP (= pEventMessage 3840))
					(KEY_NUMPAD2
						(= pEventMessage 9)
					)
				)
			)
			(evJOYSTICK
				(switch pEventMessage
					(JOY_UP
						(= pEventMessage 3840)
						(= pEventType 4)
					)
					(JOY_DOWN
						(= pEventMessage 9)
						(= pEventType 4)
					)
				)
			)
		)
		(pEvent type: pEventType message: pEventMessage)
		(super handleEvent: pEvent)
	)
)
