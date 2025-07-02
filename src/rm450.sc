;;; Sierra Script 1.0 - (do not remove this comment)
(script# 450)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm450 0
)
(synonyms
	(blackboard blackboard blackboard blackboard blackboard special board awning)
	(buffet booth)
	(tip tip buck cup jar tips)
	(entertainer entertainer babe)
)

(local
	local0
	local1
	local2
	local3
)
(instance rm450 of Rm
	(properties
		picture 450
		south 416
		west 416
	)
	
	(method (init)
		(Load rsVIEW 451)
		(super init:)
		(gAddToPics
			add: atpPiano
			add: atpChair1
			add: atpChair2
			add: atpChair3
			add: atpChair4
			add: atpChair5
			add:
				(if (and global108 (proc0_23 18))
					atpBlackboard2
				else
					atpBlackboard1
				)
			doit:
		)
		(self setScript: RoomScript)
		(if (and global108 (proc0_23 18)) (aMarker init:))
		(proc0_1)
		(cond 
			((== gGNumber_2 1)
				(aPatti
					view: 800
					init:
					loop: 1
					posn: 168 107
					setCycle: Walk
				)
				(gEgo
					ignoreActors:
					illegalBits: 0
					posn: 139 121
					view: 451
				)
				(RoomScript changeState: 10)
				(PattiScript changeState: 6)
				(proc0_3)
			)
			((== gGNumber 455)
				(= local1 1)
				(proc0_3)
				(gEgo
					ignoreActors:
					illegalBits: 0
					posn: 139 121
					view: 451
				)
				(RoomScript changeState: 10)
			)
			(else
				(if (and (== global104 6) (proc0_23 12))
					(= local1 1)
					(if (== (Random 0 3) 3) (aRoger init:))
					(if (== (Random 0 3) 3) (aElvis init:))
				)
				(if (> (gEgo y?) 130)
					(gEgo posn: 29 188)
				else
					(gEgo posn: 9 168)
				)
			)
		)
		(gEgo init:)
		(if local1
			(aPatti init:)
			(PattiScript changeState: 1)
			(blockPatti init:)
			(if (not (proc0_22 67)) (aTips init:))
			(gEgo observeBlocks: blockPatti observeControl: 16384)
		)
		(if (and (not (proc0_22 67)) global108) (aTips init:))
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0200)
			(if (not local3)
				(= local3 1)
				(gEgo
					posn: (gEgo xLast?) (gEgo yLast?)
					setMotion: 0
					observeControl: 512
					forceUpd:
				)
				(if global108 (proc255_0 450 0) else (proc255_0 450 1))
			)
		else
			(= local3 0)
		)
		(if local1
			(gEgo observeBlocks: blockPatti observeControl: 16384)
		)
	)
	
	(method (changeState newState)
		(proc21_1 self newState 1 1)
		(switch (= state newState)
			(0)
			(6
				(proc0_6)
				(gEgo ignoreActors: illegalBits: 0)
				(cond 
					((& (gEgo onControl:) $0002) (self changeState: 8))
					((& (gEgo onControl:) $0020) (self changeState: 7))
					(else (gEgo setMotion: MoveTo 118 (gEgo y?) self))
				)
				(gGame setCursor: 998 (HaveMouse))
				(= gCursorNumber 998)
			)
			(7
				(gEgo setMotion: MoveTo (gEgo x?) 113 self)
			)
			(8
				(gEgo setMotion: MoveTo 134 113 self)
			)
			(9
				(gEgo
					posn: 139 121
					view: 451
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(10
				(if (!= gGNumber_2 1)
					(User canInput: 1)
					(= gGNumber_2 1004)
				)
				(gEgo
					loop: (Random 1 2)
					cel: 0
					cycleSpeed: (Random 0 2)
					setCycle: End
				)
				(-- state)
				(= seconds (Random 3 6))
			)
			(11
				(proc0_6)
				(proc0_3)
				(= seconds (= cycles 0))
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(12
				(gEgo posn: 134 113)
				(proc0_1 3)
				(= gGNumber_2 0)
			)
			(13
				(proc0_3)
				(proc0_6)
				(= gGNumber_2 14)
				(if (not (proc0_22 9))
					(proc255_4 450 48 global171)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(14
				(if (not (proc0_22 9))
					(proc0_19 9)
					(gGame changeScore: 5)
					(proc255_0 450 49)
				)
				(global2 newRoom: 455)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(asm
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			bnt      code_04a2
			ret     
code_04a2:
			pushi    1
			lofss    'lie'
			callk    Said,  2
			bnt      code_0563
			lsg      gGNumber_2
			ldi      1004
			eq?     
			bnt      code_04bd
			pushi    0
			callb    proc0_8,  0
			jmp      code_0560
code_04bd:
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_04cc
			pushi    0
			callb    proc0_9,  0
			jmp      code_0560
code_04cc:
			lag      global108
			bnt      code_04e0
			pushi    2
			pushi    450
			pushi    2
			calle    proc255_0,  4
			jmp      code_0560
code_04e0:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      4
			and     
			bnt      code_04fe
			pushi    2
			pushi    450
			pushi    3
			calle    proc255_0,  4
			jmp      code_0560
code_04fe:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			bt       code_052b
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      32
			and     
			bt       code_052b
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      16
			and     
			bnt      code_0535
code_052b:
			pushi    #changeState
			pushi    1
			pushi    6
			self     6
			jmp      code_0560
code_0535:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			bnt      code_0553
			pushi    2
			pushi    450
			pushi    4
			calle    proc255_0,  4
			jmp      code_0560
code_0553:
			pushi    2
			pushi    450
			pushi    5
			calle    proc255_0,  4
code_0560:
			jmp      code_1342
code_0563:
			pushi    1
			lofss    'nightstand,(get<off),(get<up),(nightstand<up)'
			callk    Said,  2
			bt       code_0577
			pushi    1
			lofss    'exit/barstool,barstool'
			callk    Said,  2
			bnt      code_059f
code_0577:
			lsg      gGNumber_2
			ldi      0
			eq?     
			bnt      code_0585
			pushi    0
			callb    proc0_8,  0
			jmp      code_059c
code_0585:
			lsg      gGNumber_2
			ldi      1004
			ne?     
			bnt      code_0594
			pushi    0
			callb    proc0_9,  0
			jmp      code_059c
code_0594:
			pushi    #changeState
			pushi    1
			pushi    11
			self     6
code_059c:
			jmp      code_1342
code_059f:
			pushi    1
			lofss    'get/marker'
			callk    Said,  2
			bnt      code_062e
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_05b8
			pushi    0
			callb    proc0_9,  0
			jmp      code_062b
code_05b8:
			lag      global108
			not     
			bnt      code_05cc
			pushi    2
			pushi    450
			pushi    6
			calle    proc255_0,  4
			jmp      code_062b
code_05cc:
			pushi    1
			pushi    18
			callb    proc0_23,  2
			not     
			bnt      code_05dd
			pushi    0
			callb    proc0_11,  0
			jmp      code_062b
code_05dd:
			pushi    #inRect
			pushi    4
			pushi    10
			pushi    152
			pushi    55
			pushi    160
			lag      gEgo
			send     12
			not     
			bnt      code_05fa
			pushi    0
			callb    proc0_10,  0
			jmp      code_062b
code_05fa:
			pushi    0
			callb    proc0_6,  0
			pushi    #get
			pushi    1
			pushi    18
			lag      gEgo
			send     6
			pushi    #changeScore
			pushi    1
			pushi    50
			lag      gGame
			send     6
			pushi    #dispose
			pushi    0
			lofsa    aMarker
			send     4
			pushi    2
			pushi    450
			pushi    7
			calle    proc255_0,  4
code_062b:
			jmp      code_1342
code_062e:
			pushi    1
			lofss    'get/tip'
			callk    Said,  2
			bnt      code_06fa
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_0648
			pushi    0
			callb    proc0_9,  0
			jmp      code_06f7
code_0648:
			lag      global108
			not     
			bnt      code_065d
			pushi    2
			pushi    450
			pushi    8
			calle    proc255_0,  4
			jmp      code_06f7
code_065d:
			pushi    1
			pushi    67
			callb    proc0_22,  2
			not     
			bnt      code_066f
			pushi    0
			callb    proc0_11,  0
			jmp      code_06f7
code_066f:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			not     
			bnt      code_068e
			pushi    2
			pushi    450
			pushi    9
			calle    proc255_0,  4
			jmp      code_06f7
code_068e:
			pushi    0
			callb    proc0_6,  0
			pushi    #get
			pushi    1
			pushi    6
			lag      gEgo
			send     6
			pushi    #view
			pushi    1
			pushi    25
			pushi    #at
			pushi    1
			pushi    6
			class    Inv
			send     6
			send     6
			pushi    3
			pushi    #name
			pushi    0
			pushi    #at
			pushi    1
			pushi    6
			class    Inv
			send     6
			send     4
			push    
			pushi    450
			pushi    10
			callk    Format,  6
			pushi    #changeScore
			pushi    1
			pushi    25
			lag      gGame
			send     6
			ldi      43
			sag      global94
			pushi    1
			pushi    67
			callb    proc0_20,  2
			pushi    #dispose
			pushi    0
			lofsa    aTips
			send     4
			pushi    2
			pushi    450
			pushi    11
			calle    proc255_0,  4
code_06f7:
			jmp      code_1342
code_06fa:
			pushi    1
			lofss    'get,buy,call/attendant,attendant,drink'
			callk    Said,  2
			bnt      code_0714
			pushi    2
			pushi    450
			pushi    12
			calle    proc255_0,  4
			jmp      code_1342
code_0714:
			pushi    1
			lofss    '/attendant,attendant'
			callk    Said,  2
			bnt      code_072e
			pushi    2
			pushi    450
			pushi    13
			calle    proc255_0,  4
			jmp      code_1342
code_072e:
			pushi    1
			lofss    'give,backdrop/tip'
			callk    Said,  2
			bt       code_0742
			pushi    1
			lofss    'tip'
			callk    Said,  2
			bnt      code_0792
code_0742:
			lag      global108
			bnt      code_0755
			pushi    2
			pushi    450
			pushi    14
			calle    proc255_0,  4
			jmp      code_078f
code_0755:
			pushi    #has
			pushi    1
			pushi    6
			lag      gEgo
			send     6
			not     
			bnt      code_076a
			pushi    0
			callb    proc0_12,  0
			jmp      code_078f
code_076a:
			pushi    1
			pushi    67
			callb    proc0_22,  2
			bnt      code_0782
			pushi    2
			pushi    450
			pushi    15
			calle    proc255_0,  4
			jmp      code_078f
code_0782:
			pushi    2
			pushi    450
			pushi    16
			calle    proc255_0,  4
code_078f:
			jmp      code_1342
code_0792:
			pushi    1
			lofss    'gamble/keyboard'
			callk    Said,  2
			bnt      code_080f
			lag      global108
			bnt      code_07af
			pushi    2
			pushi    450
			pushi    17
			calle    proc255_0,  4
			jmp      code_080c
code_07af:
			pushi    #contains
			pushi    1
			lofss    aPatti
			lag      gCast
			send     6
			not     
			bnt      code_07e7
			pushi    2
			pushi    450
			pushi    18
			calle    proc255_0,  4
			lsg      global88
			ldi      4
			eq?     
			bnt      code_07e5
			pushi    5
			pushi    450
			pushi    19
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
code_07e5:
			jmp      code_080c
code_07e7:
			pushi    2
			pushi    450
			pushi    20
			calle    proc255_0,  4
			pushi    2
			pushi    450
			pushi    21
			calle    proc255_0,  4
			pushi    #changeState
			pushi    1
			pushi    1
			lofsa    PattiScript
			send     6
code_080c:
			jmp      code_1342
code_080f:
			pushi    1
			lofss    'hear'
			callk    Said,  2
			bnt      code_083c
			lal      local1
			bnt      code_082c
			pushi    2
			pushi    450
			pushi    22
			calle    proc255_0,  4
			jmp      code_0839
code_082c:
			pushi    2
			pushi    450
			pushi    23
			calle    proc255_0,  4
code_0839:
			jmp      code_1342
code_083c:
			pushi    1
			lofss    'look<below'
			callk    Said,  2
			bnt      code_0856
			pushi    2
			pushi    450
			pushi    24
			calle    proc255_0,  4
			jmp      code_1342
code_0856:
			pushi    1
			lofss    'look>'
			callk    Said,  2
			bnt      code_0a89
			pushi    1
			lofss    '/blackboard'
			callk    Said,  2
			bt       code_087e
			pushi    1
			pushi    18
			callb    proc0_23,  2
			bnt      code_08bb
			pushi    1
			lofss    '/marker'
			callk    Said,  2
			bnt      code_08bb
code_087e:
			lag      global108
			not     
			bnt      code_0892
			pushi    2
			pushi    450
			pushi    25
			calle    proc255_0,  4
			jmp      code_08b8
code_0892:
			pushi    1
			pushi    18
			callb    proc0_23,  2
			not     
			bnt      code_08ab
			pushi    2
			pushi    450
			pushi    26
			calle    proc255_0,  4
			jmp      code_08b8
code_08ab:
			pushi    2
			pushi    450
			pushi    27
			calle    proc255_0,  4
code_08b8:
			jmp      code_0a86
code_08bb:
			pushi    1
			lofss    '/wall,ceiling,burn'
			callk    Said,  2
			bnt      code_08d5
			pushi    2
			pushi    450
			pushi    28
			calle    proc255_0,  4
			jmp      code_0a86
code_08d5:
			pushi    1
			lofss    '/bar'
			callk    Said,  2
			bnt      code_0916
			lal      local1
			bnt      code_08f2
			pushi    2
			pushi    450
			pushi    29
			calle    proc255_0,  4
			jmp      code_0913
code_08f2:
			pushi    2
			pushi    450
			pushi    30
			calle    proc255_0,  4
			pushi    5
			pushi    450
			pushi    31
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
code_0913:
			jmp      code_0a86
code_0916:
			pushi    1
			lofss    '/buffet'
			callk    Said,  2
			bnt      code_0944
			pushi    2
			pushi    450
			pushi    32
			calle    proc255_0,  4
			pushi    5
			pushi    450
			pushi    33
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			jmp      code_0a86
code_0944:
			pushi    1
			lofss    '/barstool'
			callk    Said,  2
			bnt      code_095e
			pushi    2
			pushi    450
			pushi    34
			calle    proc255_0,  4
			jmp      code_0a86
code_095e:
			pushi    1
			lofss    '/drink'
			callk    Said,  2
			bnt      code_0978
			pushi    2
			pushi    450
			pushi    35
			calle    proc255_0,  4
			jmp      code_0a86
code_0978:
			pushi    1
			pushi    67
			callb    proc0_22,  2
			bnt      code_099b
			pushi    1
			lofss    '/tip'
			callk    Said,  2
			bnt      code_099b
			pushi    2
			pushi    450
			pushi    36
			calle    proc255_0,  4
			jmp      code_0a86
code_099b:
			pushi    1
			lofss    '/door'
			callk    Said,  2
			bnt      code_09b5
			pushi    2
			pushi    450
			pushi    37
			calle    proc255_0,  4
			jmp      code_0a86
code_09b5:
			pushi    1
			lofss    '/keyboard,entertainer'
			callk    Said,  2
			bnt      code_0a3c
			lsg      global104
			ldi      6
			lt?     
			bnt      code_09d5
			pushi    2
			pushi    450
			pushi    38
			calle    proc255_0,  4
			jmp      code_0a3a
code_09d5:
			pushi    1
			pushi    12
			callb    proc0_23,  2
			bnt      code_0a01
			pushi    2
			pushi    450
			pushi    39
			calle    proc255_0,  4
			pushi    5
			pushi    450
			pushi    40
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			jmp      code_0a3a
code_0a01:
			lag      global108
			not     
			bnt      code_0a15
			pushi    2
			pushi    450
			pushi    41
			calle    proc255_0,  4
			jmp      code_0a3a
code_0a15:
			pushi    1
			pushi    67
			callb    proc0_22,  2
			bnt      code_0a2d
			pushi    2
			pushi    450
			pushi    42
			calle    proc255_0,  4
			jmp      code_0a3a
code_0a2d:
			pushi    2
			pushi    450
			pushi    43
			calle    proc255_0,  4
code_0a3a:
			jmp      code_0a86
code_0a3c:
			pushi    1
			lofss    '[/bar,area]'
			callk    Said,  2
			bnt      code_0a86
			lag      global108
			bnt      code_0a59
			pushi    2
			pushi    450
			pushi    44
			calle    proc255_0,  4
			jmp      code_0a86
code_0a59:
			pushi    2
			pushi    450
			pushi    45
			calle    proc255_0,  4
			lal      local1
			bnt      code_0a79
			pushi    2
			pushi    450
			pushi    46
			calle    proc255_0,  4
			jmp      code_0a86
code_0a79:
			pushi    2
			pushi    450
			pushi    47
			calle    proc255_0,  4
code_0a86:
			jmp      code_1342
code_0a89:
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      1
			eq?     
			bnt      code_1340
			pushi    #modifiers
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      3
			and     
			not     
			bnt      code_1340
			pushi    3
			lofss    aElvis
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_0b1f
			pushi    #contains
			pushi    1
			lofss    aElvis
			lag      gCast
			send     6
			bnt      code_0b1f
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_0af3
			pushi    2
			pushi    450
			pushi    50
			calle    proc255_0,  4
			jmp      code_0b1e
code_0af3:
			dup     
			ldi      996
			eq?     
			bnt      code_0b14
			pushi    2
			pushi    450
			pushi    52
			calle    proc255_0,  4
			pushi    #changeState
			pushi    1
			pushi    3
			lofsa    ElvisScript
			send     6
			jmp      code_0b1e
code_0b14:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_0b1e:
			toss    
code_0b1f:
			pushi    3
			lofss    atpBlackboard1
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_0b95
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_0b8a
			lag      global108
			not     
			bnt      code_0b62
			pushi    2
			pushi    450
			pushi    25
			calle    proc255_0,  4
			jmp      code_0b88
code_0b62:
			pushi    1
			pushi    18
			callb    proc0_23,  2
			not     
			bnt      code_0b7b
			pushi    2
			pushi    450
			pushi    26
			calle    proc255_0,  4
			jmp      code_0b88
code_0b7b:
			pushi    2
			pushi    450
			pushi    27
			calle    proc255_0,  4
code_0b88:
			jmp      code_0b94
code_0b8a:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_0b94:
			toss    
code_0b95:
			pushi    3
			lofss    atpChair1
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bt       code_0c22
			pushi    3
			lofss    atpChair2
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bt       code_0c22
			pushi    3
			lofss    atpChair3
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bt       code_0c22
			pushi    3
			lofss    atpChair4
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bt       code_0c22
			pushi    3
			lofss    atpChair5
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_0cf9
code_0c22:
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      995
			eq?     
			bnt      code_0cee
			lsg      gGNumber_2
			ldi      1004
			eq?     
			bnt      code_0c46
			pushi    0
			callb    proc0_8,  0
			jmp      code_0cec
code_0c46:
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_0c55
			pushi    0
			callb    proc0_9,  0
			jmp      code_0cec
code_0c55:
			lag      global108
			bnt      code_0c69
			pushi    2
			pushi    450
			pushi    2
			calle    proc255_0,  4
			jmp      code_0cec
code_0c69:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      4
			and     
			bnt      code_0c87
			pushi    2
			pushi    450
			pushi    3
			calle    proc255_0,  4
			jmp      code_0cec
code_0c87:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			bt       code_0cb4
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      32
			and     
			bt       code_0cb4
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      16
			and     
			bnt      code_0cc1
code_0cb4:
			pushi    #changeState
			pushi    1
			pushi    6
			lofsa    RoomScript
			send     6
			jmp      code_0cec
code_0cc1:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			bnt      code_0cdf
			pushi    2
			pushi    450
			pushi    4
			calle    proc255_0,  4
			jmp      code_0cec
code_0cdf:
			pushi    2
			pushi    450
			pushi    5
			calle    proc255_0,  4
code_0cec:
			jmp      code_0cf8
code_0cee:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_0cf8:
			toss    
code_0cf9:
			pushi    3
			lofss    aRoger
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_0d72
			pushi    #contains
			pushi    1
			lofss    aRoger
			lag      gCast
			send     6
			bnt      code_0d72
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_0d44
			pushi    2
			pushi    450
			pushi    53
			calle    proc255_0,  4
			jmp      code_0d71
code_0d44:
			dup     
			ldi      996
			eq?     
			bnt      code_0d67
			pushi    2
			pushi    450
			pushi    54
			calle    proc255_0,  4
			pushi    2
			pushi    450
			pushi    55
			calle    proc255_0,  4
			jmp      code_0d71
code_0d67:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_0d71:
			toss    
code_0d72:
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      1
			eq?     
			bnt      code_0dff
			lsg      gGNumber_2
			ldi      1004
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      992
			eq?     
			bt       code_0da8
			lsg      gCursorNumber
			ldi      999
			eq?     
			bt       code_0da8
			lsg      gCursorNumber
			ldi      991
			eq?     
			bt       code_0da8
			lsg      gCursorNumber
			lag      gGCursorNumber
			eq?     
			bnt      code_0dff
code_0da8:
			pushi    #changeState
			pushi    1
			pushi    11
			self     6
			pushi    #setCursor
			pushi    2
			pushi    998
			pushi    0
			callk    HaveMouse,  0
			push    
			lag      gGame
			send     8
			ldi      998
			sag      gCursorNumber
			lsg      gCursorNumber
			ldi      993
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      994
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      995
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      996
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      997
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      998
			eq?     
			bnt      code_0dff
			lsg      gCursorNumber
			ldi      999
			eq?     
			bnt      code_0dff
code_0dff:
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      1
			gt?     
			bnt      code_0e6a
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      57
			lt?     
			bnt      code_0e6a
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      172
			gt?     
			bnt      code_0e6a
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      189
			lt?     
			bnt      code_0e6a
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      999
			eq?     
			bnt      code_0e5f
			pushi    #setMotion
			pushi    3
			class    MoveTo
			push    
			pushi    16
			pushi    192
			lag      gEgo
			send     10
			jmp      code_0e69
code_0e5f:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_0e69:
			toss    
code_0e6a:
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      24
			gt?     
			bnt      code_0fa7
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      45
			lt?     
			bnt      code_0fa7
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      128
			gt?     
			bnt      code_0fa7
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      157
			lt?     
			bnt      code_0fa7
			pushi    #contains
			pushi    1
			lofss    aMarker
			lag      gCast
			send     6
			bnt      code_0fa7
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_0f11
			pushi    1
			pushi    18
			callb    proc0_23,  2
			bnt      code_0f0e
			lag      global108
			not     
			bnt      code_0ee6
			pushi    2
			pushi    450
			pushi    25
			calle    proc255_0,  4
			jmp      code_0f0c
code_0ee6:
			pushi    1
			pushi    18
			callb    proc0_23,  2
			not     
			bnt      code_0eff
			pushi    2
			pushi    450
			pushi    26
			calle    proc255_0,  4
			jmp      code_0f0c
code_0eff:
			pushi    2
			pushi    450
			pushi    27
			calle    proc255_0,  4
code_0f0c:
			bnt      code_0f0e
code_0f0e:
			jmp      code_0fa6
code_0f11:
			dup     
			ldi      995
			eq?     
			bnt      code_0f9c
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_0f27
			pushi    0
			callb    proc0_9,  0
			jmp      code_0f9a
code_0f27:
			lag      global108
			not     
			bnt      code_0f3b
			pushi    2
			pushi    450
			pushi    6
			calle    proc255_0,  4
			jmp      code_0f9a
code_0f3b:
			pushi    1
			pushi    18
			callb    proc0_23,  2
			not     
			bnt      code_0f4c
			pushi    0
			callb    proc0_11,  0
			jmp      code_0f9a
code_0f4c:
			pushi    #inRect
			pushi    4
			pushi    10
			pushi    152
			pushi    55
			pushi    160
			lag      gEgo
			send     12
			not     
			bnt      code_0f69
			pushi    0
			callb    proc0_10,  0
			jmp      code_0f9a
code_0f69:
			pushi    0
			callb    proc0_6,  0
			pushi    #get
			pushi    1
			pushi    18
			lag      gEgo
			send     6
			pushi    #changeScore
			pushi    1
			pushi    50
			lag      gGame
			send     6
			pushi    #dispose
			pushi    0
			lofsa    aMarker
			send     4
			pushi    2
			pushi    450
			pushi    7
			calle    proc255_0,  4
code_0f9a:
			jmp      code_0fa6
code_0f9c:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_0fa6:
			toss    
code_0fa7:
			pushi    3
			lofss    aTips
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_110e
			pushi    #contains
			pushi    1
			lofss    aTips
			lag      gCast
			send     6
			bnt      code_110e
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_1035
			lag      global108
			bnt      code_0ff8
			pushi    2
			pushi    450
			pushi    14
			calle    proc255_0,  4
			jmp      code_1032
code_0ff8:
			pushi    #has
			pushi    1
			pushi    6
			lag      gEgo
			send     6
			not     
			bnt      code_100d
			pushi    0
			callb    proc0_12,  0
			jmp      code_1032
code_100d:
			pushi    1
			pushi    67
			callb    proc0_22,  2
			bnt      code_1025
			pushi    2
			pushi    450
			pushi    15
			calle    proc255_0,  4
			jmp      code_1032
code_1025:
			pushi    2
			pushi    450
			pushi    16
			calle    proc255_0,  4
code_1032:
			jmp      code_110d
code_1035:
			dup     
			ldi      995
			eq?     
			bnt      code_1103
			lsg      gGNumber_2
			ldi      0
			ne?     
			bnt      code_104c
			pushi    0
			callb    proc0_9,  0
			jmp      code_1101
code_104c:
			lag      global108
			not     
			bnt      code_1061
			pushi    2
			pushi    450
			pushi    8
			calle    proc255_0,  4
			jmp      code_1101
code_1061:
			pushi    1
			pushi    67
			callb    proc0_22,  2
			bnt      code_106f
			pushi    0
			callb    proc0_11,  0
code_106f:
			bnt      code_1074
			jmp      code_1101
code_1074:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			not     
			bnt      code_1098
			pushi    2
			pushi    450
			pushi    9
			calle    proc255_0,  4
			pushi    0
			callb    proc0_10,  0
			jmp      code_1101
code_1098:
			pushi    0
			callb    proc0_6,  0
			pushi    #get
			pushi    1
			pushi    6
			lag      gEgo
			send     6
			pushi    #view
			pushi    1
			pushi    25
			pushi    #at
			pushi    1
			pushi    6
			class    Inv
			send     6
			send     6
			pushi    3
			pushi    #name
			pushi    0
			pushi    #at
			pushi    1
			pushi    6
			class    Inv
			send     6
			send     4
			push    
			pushi    450
			pushi    10
			callk    Format,  6
			pushi    #changeScore
			pushi    1
			pushi    25
			lag      gGame
			send     6
			ldi      43
			sag      global94
			pushi    1
			pushi    67
			callb    proc0_19,  2
			pushi    #dispose
			pushi    0
			lofsa    aTips
			send     4
			pushi    2
			pushi    450
			pushi    11
			calle    proc255_0,  4
code_1101:
			jmp      code_110d
code_1103:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_110d:
			toss    
code_110e:
			pushi    3
			lofss    aPatti
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_1340
			pushi    #contains
			pushi    1
			lofss    aPatti
			lag      gCast
			send     6
			bnt      code_1340
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_1171
			lsg      gGNumber_2
			ldi      1004
			ne?     
			bnt      code_1163
			pushi    2
			pushi    450
			pushi    59
			calle    proc255_0,  4
			jmp      code_116e
code_1163:
			pushi    #changeState
			pushi    1
			pushi    13
			lofsa    RoomScript
			send     6
code_116e:
			jmp      code_133f
code_1171:
			dup     
			ldi      995
			eq?     
			bnt      code_130c
			pushi    #fade
			pushi    0
			lag      gTheMusic
			send     4
			pushi    2
			pushi    1
			pushi    16
			callk    Random,  4
			push    
			dup     
			ldi      1
			eq?     
			bnt      code_1197
			ldi      110
			jmp      code_1235
code_1197:
			dup     
			ldi      2
			eq?     
			bnt      code_11a2
			ldi      120
			jmp      code_1235
code_11a2:
			dup     
			ldi      3
			eq?     
			bnt      code_11ae
			ldi      206
			jmp      code_1235
code_11ae:
			dup     
			ldi      4
			eq?     
			bnt      code_11b9
			ldi      265
			jmp      code_1235
code_11b9:
			dup     
			ldi      5
			eq?     
			bnt      code_11c4
			ldi      323
			jmp      code_1235
code_11c4:
			dup     
			ldi      6
			eq?     
			bnt      code_11cf
			ldi      330
			jmp      code_1235
code_11cf:
			dup     
			ldi      7
			eq?     
			bnt      code_11da
			ldi      335
			jmp      code_1235
code_11da:
			dup     
			ldi      8
			eq?     
			bnt      code_11e5
			ldi      395
			jmp      code_1235
code_11e5:
			dup     
			ldi      9
			eq?     
			bnt      code_11f0
			ldi      399
			jmp      code_1235
code_11f0:
			dup     
			ldi      0
			eq?     
			bnt      code_11fb
			ldi      431
			jmp      code_1235
code_11fb:
			dup     
			ldi      11
			eq?     
			bnt      code_1206
			ldi      435
			jmp      code_1235
code_1206:
			dup     
			ldi      12
			eq?     
			bnt      code_1211
			ldi      500
			jmp      code_1235
code_1211:
			dup     
			ldi      13
			eq?     
			bnt      code_121c
			ldi      560
			jmp      code_1235
code_121c:
			dup     
			ldi      14
			eq?     
			bnt      code_1227
			ldi      599
			jmp      code_1235
code_1227:
			dup     
			ldi      15
			eq?     
			bnt      code_1232
			ldi      540
			jmp      code_1235
code_1232:
			ldi      261
code_1235:
			toss    
			sal      local2
			pushi    3
			pushi    450
			pushi    56
			lsl      local2
			dup     
			ldi      110
			eq?     
			bnt      code_124d
			lofsa    {Sierra}
			jmp      code_12fa
code_124d:
			dup     
			ldi      120
			eq?     
			bnt      code_1259
			lofsa    {Title}
			jmp      code_12fa
code_1259:
			dup     
			ldi      206
			eq?     
			bnt      code_1266
			lofsa    {Binocular}
			jmp      code_12fa
code_1266:
			dup     
			ldi      265
			eq?     
			bnt      code_1273
			lofsa    {Tawni's}
			jmp      code_12fa
code_1273:
			dup     
			ldi      323
			eq?     
			bnt      code_127f
			lofsa    {Dewey, Cheatem and Howe}
			jmp      code_12fa
code_127f:
			dup     
			ldi      330
			eq?     
			bnt      code_128b
			lofsa    {Dale Exotic Dance}
			jmp      code_12fa
code_128b:
			dup     
			ldi      335
			eq?     
			bnt      code_1297
			lofsa    {Dale's}
			jmp      code_12fa
code_1297:
			dup     
			ldi      395
			eq?     
			bnt      code_12a3
			lofsa    {Bambi's}
			jmp      code_12fa
code_12a3:
			dup     
			ldi      399
			eq?     
			bnt      code_12af
			lofsa    {Fat City}
			jmp      code_12fa
code_12af:
			dup     
			ldi      431
			eq?     
			bnt      code_12bb
			lofsa    {Cherri's Dance}
			jmp      code_12fa
code_12bb:
			dup     
			ldi      435
			eq?     
			bnt      code_12c7
			lofsa    {Cherri's}
			jmp      code_12fa
code_12c7:
			dup     
			ldi      500
			eq?     
			bnt      code_12d3
			lofsa    {Bamboo}
			jmp      code_12fa
code_12d3:
			dup     
			ldi      560
			eq?     
			bnt      code_12df
			lofsa    {Whitewater Rafting}
			jmp      code_12fa
code_12df:
			dup     
			ldi      599
			eq?     
			bnt      code_12eb
			lofsa    {Nontoonyt Jungle}
			jmp      code_12fa
code_12eb:
			dup     
			ldi      540
			eq?     
			bnt      code_12f7
			lofsa    {Feral Pig}
			jmp      code_12fa
code_12f7:
			lofsa    {Larry Gets Crabs}
code_12fa:
			toss    
			push    
			calle    proc255_4,  6
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
			jmp      code_133f
code_130c:
			dup     
			ldi      996
			eq?     
			bnt      code_1335
			lag      global108
			bnt      code_1326
			pushi    2
			pushi    450
			pushi    57
			calle    proc255_0,  4
			jmp      code_1333
code_1326:
			pushi    2
			pushi    450
			pushi    58
			calle    proc255_0,  4
code_1333:
			jmp      code_133f
code_1335:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_133f:
			toss    
code_1340:
			bnt      code_1342
code_1342:
			ret     
		)
	)
)

(instance aElvis of Prop
	(properties
		y 145
		x 150
		view 453
		loop 2
	)
	
	(method (init)
		(super init:)
		(self setScript: ElvisScript)
	)
)

(instance ElvisScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 3 3)
		(switch (= state newState)
			(0
				(aElvis loop: 2 setCel: 0)
				(= cycles (Random 22 111))
			)
			(1
				(if (not (Random 0 3))
					(aElvis loop: (Random 2 3) cel: 0 setCycle: End)
				else
					(= state -1)
				)
				(= cycles (Random 22 55))
			)
			(2
				(aElvis setCycle: Beg self)
				(= state -1)
			)
			(3
				(aElvis loop: 4 cel: 0 setCycle: End)
				(= cycles 22)
				(= state 1)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/man,elvis') (proc255_0 450 50))
			((Said 'address/elvis') (proc255_0 450 51))
			((Said '/elvis') (proc255_0 450 52) (self changeState: 3))
		)
	)
)

(instance aRoger of Prop
	(properties
		y 133
		x 144
		view 453
	)
	
	(method (init)
		(super init:)
		(self setScript: RogerScript)
	)
)

(instance RogerScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 4 4)
		(switch (= state newState)
			(0
				(aRoger loop: 0 setCel: 0)
				(= seconds (Random 5 10))
			)
			(1
				(if (not (Random 0 2))
					(aRoger loop: (Random 0 1) setCycle: End)
				else
					(= state -1)
				)
				(= cycles (Random 22 55))
			)
			(2
				(aRoger setCycle: Beg self)
				(= state -1)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/man,hardy') (proc255_0 450 53))
			((Said 'address/hardy,man') (proc255_0 450 51))
			((Said '/hardy') (proc255_0 450 54) (proc255_0 450 55))
		)
	)
)

(instance atpPiano of PV
	(properties
		y 116
		x 143
		view 450
		priority 8
		signal $4000
	)
)

(instance aTips of View
	(properties
		y 91
		x 150
		view 450
		cel 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 9 stopUpd:)
	)
)

(instance atpBlackboard1 of PV
	(properties
		y 153
		x 36
		view 450
		cel 3
		priority 10
	)
)

(instance atpBlackboard2 of PV
	(properties
		y 153
		x 36
		view 450
		cel 4
		priority 10
	)
)

(instance aMarker of Prop
	(properties
		y 145
		x 29
		view 450
		loop 1
		cycleSpeed 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 setCycle: Fwd)
	)
)

(instance atpChair1 of PV
	(properties
		y 122
		x 137
		view 450
		cel 1
		priority 8
	)
)

(instance atpChair2 of PV
	(properties
		y 133
		x 144
		view 450
		cel 1
		priority 9
	)
)

(instance atpChair3 of PV
	(properties
		y 145
		x 150
		view 450
		cel 1
		priority 10
	)
)

(instance atpChair4 of PV
	(properties
		y 155
		x 170
		view 450
		cel 1
		priority 11
	)
)

(instance atpChair5 of PV
	(properties
		y 155
		x 192
		view 450
		cel 1
		priority 11
	)
)

(instance aPatti of Act
	(properties
		y 84
		x 166
		view 452
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			illegalBits: 0
			setPri: 7
			setScript: PattiScript
		)
	)
)

(instance PattiScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(proc21_1 self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(= seconds 0)
				(aPatti view: 452 viewer: pianoCycler)
				(if local2
					(= temp0 1)
				else
					(= local2 (Random 451 454))
					(= temp0 (Random 1 3))
				)
				(gTheMusic stop: number: local2 loop: temp0 play: self)
			)
			(2
				(gTheMusic number: local2 loop: 1 play:)
				(= local2 0)
				(= seconds (Random 3 22))
			)
			(3
				(gTheMusic fade:)
				(aPatti viewer: 0 loop: 4 setCel: 0)
				(= seconds 7)
			)
			(4
				(proc255_0 450 61)
				(self changeState: 1)
			)
			(5)
			(6
				(gTheMusic stop: number: 499 loop: global72 play:)
				(= seconds 3)
			)
			(7
				(aPatti setMotion: MoveTo 145 112 self)
			)
			(8
				(proc255_0 450 62)
				(proc255_0 450 63)
				(gEgo get: 12)
				(proc0_24 13 340)
				(gGame changeScore: 25)
				(aPatti setLoop: -1 setMotion: MoveTo 168 112 self)
			)
			(9
				(proc255_0 450 64)
				(aPatti setMotion: MoveTo 168 46 self)
			)
			(10
				(proc255_0 450 65 67 -1 144)
				(aPatti dispose:)
				(User canInput: 1)
				(= gGNumber_2 1004)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((super handleEvent: pEvent))
			((Said 'get,make,(ask<about),gamble/music,buy')
				(gTheMusic fade:)
				(= local2
					(switch (Random 1 16)
						(1 110)
						(2 120)
						(3 206)
						(4 265)
						(5 323)
						(6 330)
						(7 335)
						(8 395)
						(9 399)
						(0 431)
						(11 435)
						(12 500)
						(13 560)
						(14 599)
						(15 540)
						(else  261)
					)
				)
				(proc255_4
					450
					56
					(switch local2
						(110 {Sierra})
						(120 {Title})
						(206 {Binocular})
						(265 {Tawni's})
						(323 {Dewey, Cheatem and Howe})
						(330 {Dale Exotic Dance})
						(335 {Dale's})
						(395 {Bambi's})
						(399 {Fat City})
						(431 {Cherri's Dance})
						(435 {Cherri's})
						(500 {Bamboo})
						(560 {Whitewater Rafting})
						(599 {Nontoonyt Jungle})
						(540 {Feral Pig})
						(else  {Larry Gets Crabs})
					)
				)
				(self changeState: 1)
			)
			((Said 'address[/entertainer]')
				(if global108
					(proc255_0 450 57)
				else
					(proc255_0 450 58)
				)
			)
			((Said 'look/entertainer')
				(if (!= gGNumber_2 1004)
					(proc255_0 450 59)
				else
					(RoomScript changeState: 13)
				)
			)
			((Said '/entertainer') (proc255_0 450 60))
		)
	)
)

(instance pianoCycler of Code
	(properties)
	
	(method (doit)
		(if (not (Random 0 9))
			(aPatti cycleSpeed: (Random 0 1))
		)
		(if (not (Random 0 5)) (aPatti loop: (Random 0 3)))
	)
)

(instance blockPatti of Blk
	(properties
		top 90
		left 157
		bottom 111
		right 177
	)
)
