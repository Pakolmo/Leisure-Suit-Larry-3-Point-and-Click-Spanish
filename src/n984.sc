;;; Sierra Script 1.0 - (do not remove this comment)
(script# 984)
(include sci.sh)
(use Main)
(use n982)
(use Obj)

(public
	proc984_0 0
)

(procedure (proc984_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16)
	(asm
		pushi    #add
		pushi    0
		pushi    23
		pushi    1
		lofss    {fl}
		pushi    #new
		pushi    0
		class    EventHandler
		send     4
		sat      temp10
		send     10
		pushi    #add
		pushi    0
		pushi    23
		pushi    1
		lofss    {ol}
		pushi    #new
		pushi    0
		class    EventHandler
		send     4
		sat      temp13
		send     10
		pushi    #add
		pushi    0
		pushi    23
		pushi    1
		lofss    {bl}
		pushi    #new
		pushi    0
		class    EventHandler
		send     4
		sat      temp16
		send     10
		pushi    #add
		pushi    5
		lst      temp10
		lst      temp13
		lsg      gRegions
		lsg      gLocales
		lst      temp16
		lap      param2
		sat      temp1
		send     14
		-ap      argc
code_0069:
		ldi      1
		bnt      code_020a
		ldi      0
		sat      temp14
		sat      temp11
		sat      temp8
		ldi      32767
		sat      temp15
		sat      temp12
		sat      temp9
		ldi      1
		sat      temp0
code_0083:
		lst      temp0
		lap      argc
		lt?     
		bnt      code_01cb
		lat      temp0
		lapi     param2
		sat      temp2
		pushi    1
		pushi    #elements
		pushi    0
		lat      temp2
		send     4
		push    
		callk    FirstNode,  2
		sat      temp3
code_00a1:
		lat      temp3
		bnt      code_01c6
		pushi    1
		pushi    1
		lst      temp3
		callk    NodeValue,  2
		sat      temp5
		push    
		callk    IsObject,  2
		bnt      code_01c6
		pushi    #firstTrue
		pushi    2
		pushi    101
		lst      temp5
		lat      temp1
		send     8
		bnt      code_00c9
		jmp      code_01ba
code_00c9:
		pushi    #distanceTo
		pushi    1
		lst      temp5
		lap      param1
		send     6
		sat      temp4
		pushi    2
		pushi    #heading
		pushi    0
		lap      param1
		send     4
		push    
		pushi    4
		pushi    #x
		pushi    0
		lap      param1
		send     4
		push    
		pushi    #y
		pushi    0
		lap      param1
		send     4
		push    
		pushi    #x
		pushi    0
		lat      temp5
		send     4
		push    
		pushi    #y
		pushi    0
		lat      temp5
		send     4
		push    
		callk    GetAngle,  8
		push    
		calle    proc982_2,  4
		sat      temp6
		pushi    2
		lst      temp6
		pushi    90
		calle    proc999_1,  4
		push    
		ldi      0
		eq?     
		bnt      code_0127
		-at      temp6
code_0127:
		pushi    2
		lst      temp5
		lsp      param1
		calle    proc982_1,  4
		sat      temp7
		bnt      code_0144
		pushi    2
		lst      temp6
		lst      temp4
		callk    SinDiv,  4
		sat      temp4
		jmp      code_016d
code_0144:
		pushi    1
		lst      temp6
		callk    Abs,  2
		push    
		ldi      90
		gt?     
		bnt      code_015c
		ldi      89
		sat      temp6
		lst      temp4
		ldi      10
		mul     
		sat      temp4
code_015c:
		pushi    1
		pushi    2
		lst      temp6
		lst      temp4
		callk    CosDiv,  4
		push    
		callk    Abs,  2
		sat      temp4
code_016d:
		lst      temp4
		ldi      0
		lt?     
		bnt      code_0179
		ldi      32767
		sat      temp4
code_0179:
		lat      temp7
		bnt      code_018e
		lst      temp4
		lat      temp15
		le?     
		bnt      code_018c
		lat      temp4
		sat      temp15
		lat      temp5
		sat      temp14
code_018c:
		jmp      code_01ba
code_018e:
		pushi    1
		lst      temp5
		calle    proc982_0,  2
		bnt      code_01ab
		lst      temp4
		lat      temp12
		le?     
		bnt      code_01a9
		lat      temp4
		sat      temp12
		lat      temp5
		sat      temp11
code_01a9:
		jmp      code_01ba
code_01ab:
		lst      temp4
		lat      temp9
		le?     
		bnt      code_01ba
		lat      temp4
		sat      temp9
		lat      temp5
		sat      temp8
code_01ba:
		pushi    1
		lst      temp3
		callk    NextNode,  2
		sat      temp3
		jmp      code_00a1
code_01c6:
		+at      temp0
		jmp      code_0083
code_01cb:
		lat      temp8
		bnt      code_01d9
		pushi    #addToEnd
		pushi    1
		lst      temp8
		lat      temp10
		send     6
code_01d9:
		lat      temp11
		bnt      code_01e7
		pushi    #addToEnd
		pushi    1
		lst      temp11
		lat      temp13
		send     6
code_01e7:
		lat      temp14
		bnt      code_01f5
		pushi    #addToEnd
		pushi    1
		lst      temp14
		lat      temp16
		send     6
code_01f5:
		lat      temp8
		bt       code_0205
		lat      temp11
		bt       code_0205
		lat      temp14
		bt       code_0205
		jmp      code_020a
		bnt      code_0207
code_0205:
		ldi      1
code_0207:
		jmp      code_0069
code_020a:
		ret     
	)
)
