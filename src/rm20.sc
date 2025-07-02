;;; Sierra Script 1.0 - (do not remove this comment)
(script# 20)
(include sci.sh)
(use Main)
(use Class_255_0)
(use gamefile.sh)
(use Game)
(use User)
(use TheMenuBar)
(use Obj)

(public
	rm20 0
)

(instance rm20 of Locale
	(properties)
	
	(method (handleEvent pEvent &tmp temp0 temp1 temp2 temp3 [temp4 30] [temp34 30] [temp64 30])
		(asm
			lag      global64
			not     
			bt       code_001d
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			bnt      code_001e
code_001d:
			ret     
code_001e:
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			dup     
			ldi      1
			eq?     
			bnt      code_0136
			pushi    #modifiers
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      3
			and     
			bnt      code_00b0
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			pushi    7
			pushi    5
			lea      @temp4
			push    
			pushi    20
			pushi    0
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
			callk    Format,  10
			push    
			pushi    67
			pushi    150
			pushi    100
			pushi    33
			pushi    999
			pushi    88
			calle    proc255_0,  14
			sat      temp2
code_007e:
			pushi    2
			pushi    #type
			pushi    0
			pushi    #new
			pushi    0
			class    Event
			send     4
			sat      temp3
			send     4
			ne?     
			bnt      code_009d
			pushi    #dispose
			pushi    0
			lat      temp3
			send     4
			jmp      code_007e
code_009d:
			pushi    #dispose
			pushi    0
			lat      temp2
			send     4
			pushi    #dispose
			pushi    0
			lat      temp3
			send     4
			jmp      code_0133
code_00b0:
			pushi    #modifiers
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      4
			and     
			bnt      code_0133
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			pushi    #canControl
			pushi    1
			pushi    1
			class    User
			send     6
code_00d3:
			pushi    2
			pushi    #type
			pushi    0
			pushi    #new
			pushi    0
			class    Event
			send     4
			sat      temp3
			send     4
			ne?     
			bnt      code_012b
			pushi    1
			lst      temp3
			callk    GlobalToLocal,  2
			pushi    #posn
			pushi    2
			pushi    #x
			pushi    0
			lat      temp3
			send     4
			push    
			pushi    #y
			pushi    0
			lat      temp3
			send     4
			push    
			pushi    210
			pushi    1
			pushi    0
			lag      gEgo
			send     14
			pushi    2
			pushi    #elements
			pushi    0
			lag      gCast
			send     4
			push    
			pushi    0
			callk    Animate,  4
			pushi    #dispose
			pushi    0
			lat      temp3
			send     4
			jmp      code_00d3
code_012b:
			pushi    #dispose
			pushi    0
			lat      temp3
			send     4
code_0133:
			jmp      code_05ee
code_0136:
			dup     
			ldi      4
			eq?     
			bnt      code_04f9
			pushi    #message
			pushi    0
			lap      pEvent
			send     4
			push    
			dup     
			ldi      11776
			eq?     
			bnt      code_0196
			pushi    1
			pushi    4
			callk    Show,  2
			pushi    2
			pushi    #elements
			pushi    0
			lag      gCast
			send     4
			push    
			pushi    0
			callk    Animate,  4
code_0164:
			pushi    0
			pushi    #type
			pushi    0
			pushi    #new
			pushi    0
			class    Event
			send     4
			sap      pEvent
			send     4
			eq?     
			bnt      code_0183
			pushi    #dispose
			pushi    0
			lap      pEvent
			send     4
			jmp      code_0164
code_0183:
			pushi    #dispose
			pushi    0
			lap      pEvent
			send     4
			pushi    1
			pushi    1
			callk    Show,  2
			ret     
			jmp      code_04f5
code_0196:
			dup     
			ldi      8192
			eq?     
			bnt      code_01a5
			pushi    0
			callk    SetDebug,  0
			jmp      code_04f5
code_01a5:
			dup     
			ldi      4608
			eq?     
			bnt      code_01d0
			pushi    2
			pushi    128
			pushi    1
			lofss    {New Ego View:}
			calle    proc255_3,  2
			sat      temp0
			push    
			callk    Load,  4
			bnt      code_01cd
			lat      temp0
			sag      global66
			pushi    0
			callb    proc0_1,  0
code_01cd:
			jmp      code_04f5
code_01d0:
			dup     
			ldi      8448
			eq?     
			bnt      code_0204
			lsg      global14
			ldi      1
			xor     
			sag      global14
			pushi    1
			pushi    4
			lea      @temp4
			push    
			pushi    20
			pushi    1
			lag      global14
			bnt      code_01f3
			lofsa    {_}
			jmp      code_01f6
code_01f3:
			lofsa    { NOT_}
code_01f6:
			push    
			callk    Format,  8
			push    
			calle    proc255_0,  2
			jmp      code_04f5
code_0204:
			dup     
			ldi      8704
			eq?     
			bnt      code_022e
			pushi    2
			pushi    129
			pushi    999
			callk    Load,  4
			bnt      code_0226
			pushi    3
			pushi    999
			pushi    1
			pushi    1
			callk    DrawPic,  6
			jmp      code_022b
code_0226:
			pushi    0
			callk    SetDebug,  0
code_022b:
			jmp      code_04f5
code_022e:
			dup     
			ldi      5888
			eq?     
			bnt      code_0243
			pushi    #canInput
			pushi    1
			pushi    1
			class    User
			send     6
			jmp      code_04f5
code_0243:
			dup     
			ldi      12800
			eq?     
			bnt      code_0256
			pushi    #showMem
			pushi    0
			lag      gGame
			send     4
			jmp      code_04f5
code_0256:
			dup     
			ldi      6400
			eq?     
			bnt      code_0267
			pushi    1
			pushi    2
			callk    Show,  2
			jmp      code_04f5
code_0267:
			dup     
			ldi      4864
			eq?     
			bnt      code_0289
			pushi    1
			pushi    4
			lea      @temp4
			push    
			pushi    20
			pushi    2
			lsg      gNumber
			callk    Format,  8
			push    
			calle    proc255_0,  2
			jmp      code_04f5
code_0289:
			dup     
			ldi      7936
			eq?     
			bnt      code_02ce
			lag      global108
			bnt      code_02ae
			ldi      0
			sag      global108
			ldi      700
			sag      global66
			pushi    3
			lea      @global83
			push    
			pushi    20
			pushi    3
			callk    Format,  6
			sag      global82
			jmp      code_02c6
code_02ae:
			ldi      1
			sag      global108
			ldi      800
			sag      global66
			pushi    3
			lea      @global83
			push    
			pushi    20
			pushi    4
			callk    Format,  6
			sag      global82
code_02c6:
			pushi    0
			callb    proc0_1,  0
			jmp      code_04f5
code_02ce:
			dup     
			ldi      5120
			eq?     
			bnt      code_0300
			pushi    1
			pushi    5
			lea      @temp4
			push    
			pushi    20
			pushi    5
			lsg      global73
			ldi      600
			div     
			push    
			lsg      global73
			ldi      600
			mod     
			push    
			ldi      10
			div     
			push    
			callk    Format,  10
			push    
			calle    proc255_0,  2
			jmp      code_04f5
code_0300:
			dup     
			ldi      12032
			eq?     
			bnt      code_0311
			pushi    1
			pushi    1
			callk    Show,  2
			jmp      code_04f5
code_0311:
			dup     
			ldi      4352
			eq?     
			bnt      code_03af
			ldi      0
			sat      temp4
			pushi    65535
			pushi    3
			lea      @temp4
			push    
			pushi    50
			lofss    {Writing to "ego.log"}
			calle    proc255_2,  6
			ne?     
			bnt      code_03ac
			pushi    4
			lea      @temp34
			push    
			pushi    20
			pushi    6
			lsg      gNumber
			callk    Format,  8
			pushi    9
			lea      @temp64
			push    
			pushi    20
			pushi    7
			pushi    #view
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #loop
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #cel
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #x
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #priority
			pushi    0
			lag      gEgo
			send     4
			push    
			callk    Format,  18
			pushi    #name
			pushi    1
			lofss    {ego.log}
			pushi    241
			pushi    5
			lea      @temp34
			push    
			lea      @temp4
			push    
			lofss    {]_}
			lea      @temp64
			push    
			lofss    {\0D\n}
			pushi    243
			pushi    0
			class    gamefile_sh
			send     24
code_03ac:
			jmp      code_04f5
code_03af:
			dup     
			ldi      11520
			eq?     
			bnt      code_03bd
			ldi      1
			sag      global4
			jmp      code_04f5
code_03bd:
			dup     
			ldi      11264
			eq?     
			bnt      code_03cb
			ldi      1
			sag      global4
			jmp      code_04f5
code_03cb:
			dup     
			ldi      20
			eq?     
			bnt      code_0410
			pushi    1
			lofss    {Teleport to}
			calle    proc255_3,  2
			sat      temp0
			pushi    2
			pushi    130
			lst      temp0
			callk    Load,  4
			bnt      code_03fc
			pushi    0
			callb    proc0_1,  0
			pushi    #newRoom
			pushi    1
			lst      temp0
			lag      global2
			send     6
			jmp      code_040d
code_03fc:
			pushi    2
			pushi    20
			pushi    8
			calle    proc255_0,  4
			pushi    0
			callk    SetDebug,  0
code_040d:
			jmp      code_04f5
code_0410:
			dup     
			ldi      4
			eq?     
			bnt      code_0468
			lag      global97
			bnt      code_0436
			ldi      0
			sag      global97
			pushi    #draw
			pushi    0
			class    TheMenuBar
			send     4
			pushi    #enable
			pushi    0
			class    SL
			send     4
			pushi    0
			callb    proc0_1,  0
			jmp      code_0465
code_0436:
			ldi      1
			sag      global97
			pushi    1
			lofss    {Teleport to}
			calle    proc255_3,  2
			sat      temp0
			pushi    2
			pushi    130
			lst      temp0
			callk    Load,  4
			bnt      code_0460
			pushi    #newRoom
			pushi    1
			lst      temp0
			lag      global2
			send     6
			jmp      code_0465
code_0460:
			pushi    0
			callk    SetDebug,  0
code_0465:
			jmp      code_04f5
code_0468:
			dup     
			ldi      5
			eq?     
			bnt      code_04ef
			pushi    5
			pushi    10
			lea      @temp4
			push    
			lofss    {view %d loop %d cel %d posn %d %d pri %d OnControl $%x Origin on $%x}
			pushi    #view
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #loop
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #cel
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #x
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #priority
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #onControl
			pushi    1
			pushi    1
			lag      gEgo
			send     6
			push    
			callk    Format,  20
			push    
			pushi    82
			pushi    #view
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #loop
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #cel
			pushi    0
			lag      gEgo
			send     4
			push    
			calle    proc255_0,  10
			jmp      code_04f5
code_04ef:
			dup     
			ldi      8
			eq?     
			bnt      code_04f5
code_04f5:
			toss    
			jmp      code_05ee
code_04f9:
			dup     
			ldi      128
			eq?     
			bnt      code_05ee
			pushi    1
			lofss    'tp'
			callk    Said,  2
			bnt      code_0547
			pushi    1
			lofss    {Teleport to}
			calle    proc255_3,  2
			sat      temp0
			pushi    2
			pushi    130
			lst      temp0
			callk    Load,  4
			bnt      code_0536
			pushi    0
			callb    proc0_1,  0
			pushi    #newRoom
			pushi    1
			lst      temp0
			lag      global2
			send     6
			jmp      code_0547
code_0536:
			pushi    2
			pushi    20
			pushi    8
			calle    proc255_0,  4
			pushi    0
			callk    SetDebug,  0
code_0547:
			pushi    1
			lofss    'pitch>'
			callk    Said,  2
			bnt      code_059b
			pushi    #saidMe
			pushi    0
			lag      gInv
			send     4
			sat      temp1
			bnt      code_059b
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			pushi    #ownedBy
			pushi    1
			lsg      gEgo
			lat      temp1
			send     6
			not     
			bnt      code_0584
			pushi    2
			pushi    20
			pushi    9
			calle    proc255_0,  4
			jmp      code_059b
code_0584:
			pushi    2
			pushi    20
			pushi    10
			calle    proc255_0,  4
			pushi    #moveTo
			pushi    1
			pushi    65535
			lat      temp1
			send     6
code_059b:
			pushi    1
			lofss    'get>'
			callk    Said,  2
			bnt      code_05ee
			pushi    #saidMe
			pushi    0
			lag      gInv
			send     4
			sat      temp1
			bnt      code_05ee
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			pushi    #ownedBy
			pushi    1
			lsg      gEgo
			lat      temp1
			send     6
			bnt      code_05d7
			pushi    2
			pushi    20
			pushi    11
			calle    proc255_0,  4
			jmp      code_05ee
code_05d7:
			pushi    2
			pushi    20
			pushi    12
			calle    proc255_0,  4
			pushi    #moveTo
			pushi    1
			lsg      gEgo
			lat      temp1
			send     6
code_05ee:
			toss    
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			not     
			bnt      code_0603
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			super    Locale,  6
code_0603:
			ret     
		)
	)
)
