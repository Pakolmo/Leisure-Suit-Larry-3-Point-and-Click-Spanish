;;; Sierra Script 1.0 - (do not remove this comment)
(script# 340)
(include sci.sh)
(use Main)
(use Class_255_0)
(use n958)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm340 0
)

(local
	[local0 45]
	local45
	theALadyLR_Top
	local47
	local48
	[local49 30]
	[local79 15]
	[local94 15]
	[local109 15]
	local124
	local125
	local126
)
(instance rm340 of Rm
	(properties
		picture 340
		horizon 1
		south 240
	)
	
	(method (init)
		(User canInput: 0 mapKeyToDir: 0)
		(Load rsTEXT 341)
		(Load rsVIEW 705)
		(Load rsVIEW 344)
		(proc958_0 132 21 22 23 24 25 26 27 10 340 341)
		(= gGNumber_2 16)
		(super init:)
		(gAddToPics
			add: atpChair
			add: atpManUR
			add: atpManLR
			add: atpManUL_Bottom
			add: atpLadyLR_Bottom
			add: atpLadyUL_Bottom
			doit:
		)
		(aManUL_Top init:)
		(aLadyUL_Top init:)
		(aLadyLR_Top init:)
		(aDrummer init:)
		(aComic init:)
		(aSign init:)
		(if (and (proc0_23 13) (gEgo has: 12))
			(aBottle setPri: 10 ignoreActors: init:)
		)
		(self setScript: RoomScript)
		(proc0_1 3 (+ 705 global118))
		(gEgo posn: 159 188 init:)
		(if (proc0_22 13)
			(aAl loop: 5 cel: 4 init: stopUpd:)
			(aBill loop: 4 cel: 4 init: stopUpd:)
		else
			(aAlTop init:)
			(aBillTop init:)
			(aAl init:)
			(aBill init:)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if local48 (proc255_0 340 0))
		(= gGNumber_2 0)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_6)
				(proc0_3)
				(if (< (gEgo x?) 167)
					(gEgo illegalBits: 0 setMotion: MoveTo 153 152 self)
					(= local47 4)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 176 152 self)
					(= local47 5)
				)
			)
			(2
				(= cycles (= seconds 0))
				(gEgo
					view: 705
					loop: local47
					cel: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(3
				(if (== (ComicScript state?) 0)
					(ComicScript changeState: 1)
				)
				(User canInput: 1)
				(= gGNumber_2 1004)
			)
			(4
				(gEgo setCycle: Beg self)
				(gGame setCursor: 999)
			)
			(5
				(= gGNumber_2 16)
				(proc0_1 3 (+ 705 global118))
				(if local48 (proc255_0 340 39))
			)
			(6
				(proc0_3)
				(= local49 0)
				(while (> 5 (StrLen @local49))
					(proc255_2
						@local49
						50
						{Simplemente di lo que quieras decir:}
						80
						{Interface del Autor}
					)
				)
				(aAlTop loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(aAlTop loop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(proc255_4 340 40 @local49)
				(aAlTop loop: 2 setCel: 255 setCycle: Beg self)
			)
			(9
				(aBillTop show:)
				(= seconds 3)
			)
			(10
				(proc255_4 340 41 @local49)
				(= seconds 3)
			)
			(11
				(aBillTop hide:)
				(aAlTop setCycle: End self)
			)
			(12
				(aAlTop loop: 3 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(proc255_4 340 42 @local49)
				(aAl dispose:)
				(aBill dispose:)
				(aAlTop
					posn: 99 191
					loop: 5
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(aBillTop
					posn: 70 190
					loop: 4
					cel: 0
					cycleSpeed: 1
					show:
					setCycle: End self
				)
			)
			(14
				(proc0_4)
				(aAlTop stopUpd:)
				(aBillTop stopUpd:)
				(if (not (proc0_22 13))
					(proc0_19 13)
					(gGame changeScore: 5)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'boo')
				(if local48
					(proc255_0 340 1)
					(proc255_4 340 2 global170)
					(proc255_0 340 3 67 -1 144)
				else
					(proc255_0 340 4)
				)
			)
			((Said 'applaud') (if local48 (proc255_0 340 5) else (proc255_0 340 4)))
			((and global64 (Said 'test/joke'))
				(= local45
					(proc255_3 {First joke (from 1 to LAST JOKE):})
				)
				(proc255_4 340 6 local45)
			)
			((Said 'address/comedian') (if local48 (proc255_0 340 7) else (proc255_0 340 8)))
			((Said 'address/bob') (proc255_0 340 9))
			(
				(or
					(Said 'get/microphone')
					(Said 'nightstand,get,jump,climb<on/backstage')
				)
				(proc255_0 340 10)
			)
			((Said 'address/man,bill,babe,al')
				(if
					(or
						(& (gEgo onControl:) $0008)
						(& (gEgo onControl:) $0004)
					)
					(if (proc0_22 13)
						(proc255_0 340 11)
					else
						(self changeState: 6)
					)
				else
					(proc255_4 340 12 global82)
				)
			)
			((Said 'get/bottle,beer')
				(cond 
					((and (!= gGNumber_2 16) (!= gGNumber_2 1004)) (proc0_9))
					(
					(or (not (proc0_23 13)) (not (gEgo has: 12))) (proc255_0 340 11))
					((not (& (gEgo onControl:) $0080)) (proc0_10))
					(else
						(proc0_6)
						(aBottle dispose:)
						(gGame changeScore: 15)
						(proc255_0 340 13)
						(gEgo get: 13)
					)
				)
			)
			(
				(or
					(Said 'nightstand,(get<off),(get<up),(nightstand<up)')
					(Said 'exit/barstool')
				)
				(cond 
					((== gGNumber_2 16) (proc0_8))
					((!= gGNumber_2 1004) (proc0_9))
					(else (proc0_3) (self changeState: 4) (gGame setCursor: 999))
				)
			)
			((Said 'lie')
				(cond 
					((not (& (gEgo onControl:) $0002)) (proc255_0 340 14))
					((== gGNumber_2 1004) (proc0_8))
					((!= gGNumber_2 16) (proc0_9))
					(else (self changeState: 1))
				)
			)
			((Said 'look>')
				(cond 
					((Said '/barstool') (proc255_0 340 15))
					((Said '/backstage') (proc255_0 340 16))
					((Said '/mask') (proc255_0 340 17))
					((Said '/awning') (proc255_0 340 18))
					((Said '/cigarette,smoke') (proc255_0 340 19))
					((Said '/burn,burn') (proc255_0 340 20))
					(
						(or
							(Said 'buy/beer,drink,beer')
							(Said 'buy//beer,drink,beer')
							(Said '/attendant,attendant,attendant')
							(Said '//attendant,attendant,attendant')
						)
						(proc255_0 340 21)
					)
					((Said '/door') (proc255_0 340 22))
					((Said '/comedian') (if local48 (proc255_0 340 23) else (proc255_0 340 24)))
					((Said '/babe') (proc255_0 340 25))
					((Said '/man,couple')
						(if
							(and
								(not (proc0_22 13))
								(or
									(& (gEgo onControl:) $0008)
									(& (gEgo onControl:) $0004)
								)
							)
							(proc255_0 340 26)
						else
							(proc255_0 340 27)
						)
					)
					((Said '/bottle')
						(if (and (proc0_23 13) (gEgo has: 12))
							(proc255_0 340 28)
						else
							(proc255_0 340 11)
						)
					)
					((Said '/al')
						(cond 
							((proc0_22 13) (proc255_0 340 29) (proc255_0 340 30 67 -1 144))
							((& (gEgo onControl:) $0008) (proc255_0 340 31))
							(else (proc255_0 340 32))
						)
					)
					((Said '/bill')
						(cond 
							((proc0_22 13) (pEvent claimed: 0))
							((& (gEgo onControl:) $0004) (proc255_0 340 33))
							(else (proc255_0 340 34))
						)
					)
					((Said '/buffet')
						(if
							(and
								(& (gEgo onControl:) $0080)
								(proc0_23 13)
								(gEgo has: 12)
							)
							(proc255_0 340 28)
						else
							(proc255_0 340 35)
						)
					)
					((Said '/bob') (if local48 (proc255_0 340 36) else (proc255_0 340 37)))
					((Said '[/area,couple]') (proc255_0 340 38))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(== (pEvent type?) evMOUSEBUTTON)
						(== gGNumber_2 1004)
						(== gCursorNumber 992)
					)
					(proc0_4)
					(self changeState: 4)
				)
				(if (proc0_26 aAl (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((proc0_22 13) (proc255_0 340 29) (proc255_0 340 30 67 -1 144))
								((& (gEgo onControl:) $0008) (proc255_0 340 31))
								(else (proc255_0 340 32))
							)
						)
						(996
							(if
								(or
									(& (gEgo onControl:) $0008)
									(& (gEgo onControl:) $0004)
									(& (gEgo onControl:) $8000)
									(& (gEgo onControl:) $0001)
								)
								(if (proc0_22 13)
									(proc255_0 340 11)
								else
									(self changeState: 6)
								)
							else
								(proc255_4 340 12 global82)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 95)
						(< (pEvent x?) 123)
						(> (pEvent y?) 146)
						(< (pEvent y?) 175)
						(gCast contains: aAl)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((proc0_22 13) (proc255_0 340 29) (proc255_0 340 30 67 -1 144))
								((& (gEgo onControl:) $0008) (proc255_0 340 31))
								(else (proc255_0 340 32))
							)
						)
						(996
							(if
								(or
									(& (gEgo onControl:) $0008)
									(& (gEgo onControl:) $0004)
									(& (gEgo onControl:) $8000)
									(& (gEgo onControl:) $0001)
								)
								(if (proc0_22 13)
									(proc255_0 340 11)
								else
									(self changeState: 6)
								)
							else
								(proc255_4 340 12 global82)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aBill (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((proc0_22 13) (pEvent claimed: 0))
								((& (gEgo onControl:) $0004) (proc255_0 340 33))
								(else (proc255_0 340 34))
							)
						)
						(996
							(if
								(or
									(& (gEgo onControl:) $0008)
									(& (gEgo onControl:) $0004)
								)
								(if (proc0_22 13)
									(proc255_0 340 11)
								else
									(self changeState: 6)
								)
							else
								(proc255_4 340 12 global82)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 319)
						(> (pEvent y?) 21)
						(< (pEvent y?) 88)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 340 38))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 139)
						(< (pEvent x?) 181)
						(> (pEvent y?) 181)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 156 190)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aBottle (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((proc0_22 13) (pEvent claimed: 0))
								((& (gEgo onControl:) $0004) (proc255_0 340 33))
								(else (proc255_0 340 34))
							)
						)
						(995
							(cond 
								((and (!= gGNumber_2 16) (!= gGNumber_2 1004)) (proc0_9))
								(
								(or (not (proc0_23 13)) (not (gEgo has: 12))) (proc255_0 340 11))
								((not (& (gEgo onControl:) $0080)) (proc0_10))
								(else
									(proc0_6)
									(aBottle dispose:)
									(gGame changeScore: 15)
									(proc255_0 340 13)
									(gEgo get: 13)
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 155)
						(< (pEvent x?) 178)
						(> (pEvent y?) 122)
						(< (pEvent y?) 141)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((not (& (gEgo onControl:) $0002)) (proc255_0 340 14))
								((== gGNumber_2 1004) (proc0_8))
								((!= gGNumber_2 16) (proc0_9))
								(else (self changeState: 1))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance ComicScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== -1 (gTheMusic prevSignal?)) (== state 7))
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp [temp0 200] temp200 temp201 temp202 temp203 temp204 temp205 temp206 temp207 temp208)
		(asm
			lap      newState
			aTop     state
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_0f2e
			jmp      code_15da
code_0f2e:
			dup     
			ldi      1
			eq?     
			bnt      code_0f74
			lsg      global87
			ldi      39
			gt?     
			bnt      code_0f47
			pushi    #setCycle
			pushi    1
			class    Fwd
			push    
			lofsa    aSign
			send     6
code_0f47:
			pushi    #number
			pushi    1
			pushi    10
			pushi    6
			pushi    1
			pushi    65535
			pushi    42
			pushi    0
			lag      gTheMusic
			send     16
			pushi    #loop
			pushi    1
			pushi    2
			pushi    126
			pushi    1
			class    Fwd
			push    
			lofsa    aDrummer
			send     12
			ldi      4
			aTop     seconds
			jmp      code_15da
code_0f74:
			dup     
			ldi      2
			eq?     
			bnt      code_0fcf
			pushi    2
			pushi    340
			pushi    43
			calle    proc255_0,  4
			lsg      gGNumber_2
			ldi      1004
			ne?     
			bnt      code_0f9c
			pushi    2
			pushi    340
			pushi    44
			calle    proc255_0,  4
code_0f9c:
			pushi    #stop
			pushi    0
			pushi    43
			pushi    1
			pushi    340
			pushi    6
			pushi    1
			pushi    1
			pushi    42
			pushi    0
			lag      gTheMusic
			send     20
			pushi    #cycleSpeed
			pushi    1
			pushi    1
			pushi    6
			pushi    1
			pushi    1
			lofsa    aDrummer
			send     12
			ldi      3
			aTop     seconds
			jmp      code_15da
code_0fcf:
			dup     
			ldi      3
			eq?     
			bnt      code_0feb
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    160
			pushi    58
			pushSelf
			lofsa    aComic
			send     12
			jmp      code_15da
code_0feb:
			dup     
			ldi      4
			eq?     
			bnt      code_100d
			pushi    #setPri
			pushi    1
			pushi    65535
			pushi    210
			pushi    4
			class    MoveTo
			push    
			pushi    160
			pushi    78
			pushSelf
			lofsa    aComic
			send     18
			jmp      code_15da
code_100d:
			dup     
			ldi      5
			eq?     
			bnt      code_1036
			lsg      global87
			ldi      39
			gt?     
			bnt      code_102b
			pushi    #setCel
			pushi    1
			pushi    1
			pushi    197
			pushi    0
			lofsa    aSign
			send     10
code_102b:
			ldi      1
			sal      local48
			ldi      3
			aTop     seconds
			jmp      code_15da
code_1036:
			dup     
			ldi      6
			eq?     
			bnt      code_1056
			pushi    #loop
			pushi    1
			pushi    4
			pushi    208
			pushi    1
			lofss    talkCycler
			lofsa    aComic
			send     12
			ldi      3
			aTop     seconds
			jmp      code_15da
code_1056:
			dup     
			ldi      7
			eq?     
			bnt      code_105f
			jmp      code_15da
code_105f:
			dup     
			ldi      8
			eq?     
			bnt      code_1092
			pushi    #cycleSpeed
			pushi    1
			pushi    0
			pushi    6
			pushi    1
			pushi    0
			pushi    201
			pushi    1
			pushi    0
			lofsa    aDrummer
			send     18
			pushi    2
			pushi    340
			pushi    45
			calle    proc255_0,  4
			ldi      3
			aTop     seconds
			jmp      code_15da
code_1092:
			dup     
			ldi      9
			eq?     
			bnt      code_1153
			pushi    #number
			pushi    1
			pushi    341
			pushi    6
			pushi    1
			pushi    65535
			pushi    42
			pushi    0
			lag      gTheMusic
			send     16
			lsg      gGNumber_2
			ldi      1004
			ne?     
			bnt      code_10c3
			pushi    2
			pushi    340
			pushi    46
			calle    proc255_0,  4
code_10c3:
			pushi    2
			pushi    340
			pushi    47
			calle    proc255_0,  4
			ldi      0
			sal      local79
			ldi      0
			sal      local94
			ldi      0
			sal      local109
code_10dc:
			pushi    3
			pushi    1
			lea      @local79
			push    
			callk    StrLen,  2
			gt?     
			bnt      code_10fd
			pushi    3
			lea      @local79
			push    
			pushi    15
			lofss    {Grupo +tnico 1:}
			calle    proc255_2,  6
			jmp      code_10dc
code_10fd:
			pushi    3
			pushi    1
			lea      @local94
			push    
			callk    StrLen,  2
			gt?     
			bnt      code_111e
			pushi    3
			lea      @local94
			push    
			pushi    15
			lofss    {Grupo +tnico 2:}
			calle    proc255_2,  6
			jmp      code_10fd
code_111e:
			pushi    3
			pushi    1
			lea      @local109
			push    
			callk    StrLen,  2
			gt?     
			bnt      code_113f
			pushi    3
			lea      @local109
			push    
			pushi    15
			lofss    {Grupo +tnico 3:}
			calle    proc255_2,  6
			jmp      code_111e
code_113f:
			pushi    2
			pushi    340
			pushi    48
			calle    proc255_0,  4
			ldi      3
			aTop     seconds
			jmp      code_15da
code_1153:
			dup     
			ldi      10
			eq?     
			bnt      code_1173
			pushi    #loop
			pushi    1
			pushi    4
			pushi    208
			pushi    1
			lofss    talkCycler
			lofsa    aComic
			send     12
			ldi      3
			aTop     seconds
			jmp      code_15da
code_1173:
			dup     
			ldi      11
			eq?     
			bnt      code_1378
			pushi    #setCycle
			pushi    1
			class    Walk
			push    
			pushi    208
			pushi    1
			pushi    0
			lofsa    aComic
			send     12
			ldi      0
			sat      temp204
			+at      temp204
			pushi    2
			pushi    0
			pushi    42
			callk    Random,  4
			sat      temp206
			lal      local45
			bnt      code_11ae
			pushi    0
			+al      local45
			sat      temp206
			sali     local0
code_11ae:
			lat      temp206
			lsli     local0
			ldi      0
			eq?     
			bnt      code_1366
			pushi    1
			lat      temp206
			sali     local0
			pushi    2
			pushi    49
			pushi    51
			callk    Random,  4
			sal      local124
			sal      local125
			lal      local124
			sal      local126
			lsl      local124
			lal      local125
			eq?     
			bnt      code_11e3
			pushi    2
			pushi    49
			pushi    51
			callk    Random,  4
			sal      local125
code_11e3:
			lsl      local126
			lal      local124
			eq?     
			bt       code_11f1
			lsl      local126
			lal      local125
			eq?     
			bnt      code_11fe
code_11f1:
			pushi    2
			pushi    49
			pushi    51
			callk    Random,  4
			sal      local126
			jmp      code_11e3
code_11fe:
			ldi      0
			sat      temp207
code_1203:
			lst      temp207
			ldi      5
			lt?     
			bnt      code_1304
			ldi      0
			sat      temp208
			pushi    5
			lea      @temp0
			push    
			pushi    340
			pushi    49
			pushi    341
			lst      temp207
			lst      temp206
			ldi      5
			mul     
			add     
			push    
			callk    Format,  10
			pushi    32
			pushi    2
			lea      @temp0
			push    
			pushi    1
			callk    StrAt,  4
			ne?     
			bnt      code_12fe
			ldi      0
			sat      temp205
code_1243:
			lst      temp205
			pushi    1
			lea      @temp0
			push    
			callk    StrLen,  2
			lt?     
			bnt      code_12e3
			pushi    47
			pushi    2
			lea      @temp0
			push    
			lst      temp205
			callk    StrAt,  4
			eq?     
			bnt      code_12dd
			pushi    3
			lea      @temp0
			push    
			lst      temp205
			pushi    37
			callk    StrAt,  6
			pushi    2
			lea      @temp0
			push    
			+st      temp205
			callk    StrAt,  4
			push    
			dup     
			lal      local124
			eq?     
			bnt      code_1294
			lea      @local79
			push    
			lat      temp208
			sati     temp200
			+at      temp208
			jmp      code_12cb
code_1294:
			dup     
			lal      local125
			eq?     
			bnt      code_12a9
			lea      @local94
			push    
			lat      temp208
			sati     temp200
			+at      temp208
			jmp      code_12cb
code_12a9:
			dup     
			lal      local126
			eq?     
			bnt      code_12be
			lea      @local109
			push    
			lat      temp208
			sati     temp200
			+at      temp208
			jmp      code_12cb
code_12be:
			lea      @local109
			push    
			lat      temp208
			sati     temp200
			+at      temp208
code_12cb:
			toss    
			pushi    3
			lea      @temp0
			push    
			lst      temp205
			pushi    115
			callk    StrAt,  6
			+at      temp205
code_12dd:
			+at      temp205
			jmp      code_1243
code_12e3:
			pushi    6
			lea      @temp0
			push    
			lst      temp200
			lst      temp201
			lst      temp202
			lst      temp203
			lst      temp204
			calle    proc255_4,  12
code_12fe:
			+at      temp207
			jmp      code_1203
code_1304:
			lsl      local45
			ldi      42
			gt?     
			bnt      code_132f
			lal      local45
			bnt      code_1322
			pushi    2
			pushi    340
			pushi    50
			calle    proc255_0,  4
			ldi      0
			sal      local45
			jmp      code_132f
code_1322:
			pushi    2
			pushi    340
			pushi    51
			calle    proc255_0,  4
code_132f:
			pushi    #setCycle
			pushi    1
			class    End
			push    
			lofsa    aDrummer
			send     6
			pushi    1
			pushi    11
			callk    DoSound,  2
			push    
			ldi      5
			gt?     
			bnt      code_1364
			pushi    #number
			pushi    1
			pushi    2
			pushi    21
			pushi    27
			callk    Random,  4
			push    
			pushi    6
			pushi    1
			pushi    1
			pushi    42
			pushi    0
			lag      gTheSoundFX
			send     16
code_1364:
			jmp      code_1371
code_1366:
			lst      temp204
			ldi      1000
			ge?     
			ldi      12
			aTop     state
code_1371:
			ldi      2
			aTop     seconds
			jmp      code_15da
code_1378:
			dup     
			ldi      12
			eq?     
			bnt      code_13a8
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    2
			pushi    125
			pushi    195
			callk    Random,  4
			push    
			pushi    2
			pushi    66
			pushi    80
			callk    Random,  4
			push    
			pushSelf
			lofsa    aComic
			send     12
			ldi      9
			aTop     state
			jmp      code_15da
code_13a8:
			dup     
			ldi      13
			eq?     
			bnt      code_13da
			pushi    #fade
			pushi    0
			lag      gTheMusic
			send     4
			pushi    2
			pushi    340
			pushi    52
			calle    proc255_0,  4
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    158
			pushi    75
			pushSelf
			lofsa    aComic
			send     12
			jmp      code_15da
code_13da:
			dup     
			ldi      14
			eq?     
			bnt      code_1410
			pushi    2
			pushi    340
			pushi    53
			calle    proc255_0,  4
			pushi    1
			pushi    43
			callb    proc0_22,  2
			not     
			bnt      code_1409
			pushi    1
			pushi    43
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    100
			lag      gGame
			send     6
code_1409:
			ldi      2
			aTop     seconds
			jmp      code_15da
code_1410:
			dup     
			ldi      15
			eq?     
			bnt      code_1440
			pushi    #view
			pushi    1
			pushi    344
			pushi    6
			pushi    1
			pushi    2
			pushi    7
			pushi    1
			pushi    0
			pushi    126
			pushi    2
			class    End
			push    
			pushSelf
			pushi    210
			pushi    1
			pushi    0
			lofsa    aComic
			send     32
			jmp      code_15da
code_1440:
			dup     
			ldi      16
			eq?     
			bnt      code_1462
			pushi    #setCycle
			pushi    1
			class    Walk
			push    
			pushi    210
			pushi    4
			class    MoveTo
			push    
			pushi    125
			pushi    75
			pushSelf
			lofsa    aComic
			send     18
			jmp      code_15da
code_1462:
			dup     
			ldi      17
			eq?     
			bnt      code_147e
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    194
			pushi    75
			pushSelf
			lofsa    aComic
			send     12
			jmp      code_15da
code_147e:
			dup     
			ldi      18
			eq?     
			bnt      code_149a
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    161
			pushi    75
			pushSelf
			lofsa    aComic
			send     12
			jmp      code_15da
code_149a:
			dup     
			ldi      19
			eq?     
			bnt      code_14be
			pushi    #loop
			pushi    1
			pushi    2
			pushi    201
			pushi    1
			pushi    255
			pushi    126
			pushi    2
			class    Beg
			push    
			pushSelf
			lofsa    aComic
			send     20
			jmp      code_15da
code_14be:
			dup     
			ldi      20
			eq?     
			bnt      code_14e4
			pushi    #view
			pushi    1
			pushi    343
			pushi    6
			pushi    1
			pushi    2
			pushi    126
			pushi    1
			class    Walk
			push    
			lofsa    aComic
			send     18
			ldi      2
			aTop     seconds
			jmp      code_15da
code_14e4:
			dup     
			ldi      21
			eq?     
			bnt      code_1526
			pushi    2
			pushi    340
			pushi    54
			calle    proc255_0,  4
			pushi    #number
			pushi    1
			pushi    340
			pushi    6
			pushi    1
			pushi    65535
			pushi    42
			pushi    0
			lag      gTheMusic
			send     16
			lsg      global87
			ldi      39
			gt?     
			bnt      code_151f
			pushi    #setCycle
			pushi    1
			class    Fwd
			push    
			lofsa    aSign
			send     6
code_151f:
			ldi      2
			aTop     seconds
			jmp      code_15da
code_1526:
			dup     
			ldi      22
			eq?     
			bnt      code_1542
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    160
			pushi    57
			pushSelf
			lofsa    aComic
			send     12
			jmp      code_15da
code_1542:
			dup     
			ldi      23
			eq?     
			bnt      code_1577
			pushi    2
			pushi    340
			pushi    55
			calle    proc255_0,  4
			pushi    #setMotion
			pushi    4
			class    MoveTo
			push    
			pushi    241
			pushi    58
			pushSelf
			lofsa    aComic
			send     12
			pushi    #fade
			pushi    0
			lag      gTheMusic
			send     4
			ldi      0
			sal      local48
			jmp      code_15da
code_1577:
			dup     
			ldi      24
			eq?     
			bnt      code_15da
			pushi    #hide
			pushi    0
			lofsa    aComic
			send     4
			lsg      global87
			ldi      39
			gt?     
			bnt      code_159f
			pushi    #setCel
			pushi    1
			pushi    0
			pushi    197
			pushi    0
			lofsa    aSign
			send     10
code_159f:
			pushi    #stopUpd
			pushi    0
			lofsa    aDrummer
			send     4
			pushi    #number
			pushi    1
			pushi    341
			pushi    6
			pushi    1
			lsg      global72
			pushi    42
			pushi    0
			lag      gTheMusic
			send     16
			pushi    0
			callb    proc0_3,  0
			pushi    #changeState
			pushi    1
			pushi    4
			lofsa    RoomScript
			send     6
			pushi    #setCursor
			pushi    1
			pushi    999
			lag      gGame
			send     6
code_15da:
			toss    
			ret     
		)
	)
)

(instance drinkerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 10)))
			(1
				(switch (Random 1 3)
					(1
						(= theALadyLR_Top aLadyLR_Top)
					)
					(2
						(= theALadyLR_Top aLadyUL_Top)
					)
					(3
						(= theALadyLR_Top aManUL_Top)
					)
				)
				(theALadyLR_Top setCycle: End self)
			)
			(2
				(if (== theALadyLR_Top aLadyUL_Top) (= state -1))
				(= cycles (Random 5 22))
			)
			(3
				(theALadyLR_Top setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance atpManUR of PV
	(properties
		y 186
		x 247
		view 340
		cel 9
	)
)

(instance atpManLR of PV
	(properties
		y 128
		x 249
		view 340
		cel 8
	)
)

(instance atpChair of PV
	(properties
		y 150
		x 167
		view 340
		priority 11
	)
)

(instance aDrummer of Prop
	(properties
		y 71
		x 79
		view 345
	)
	
	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance aBottle of View
	(properties
		y 119
		x 165
		view 340
		cel 5
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aBillTop of Prop
	(properties
		y 155
		x 67
		view 346
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd setPri: 14 ignoreActors: hide:)
	)
)

(instance aBill of View
	(properties
		y 190
		x 70
		view 346
		priority 14
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aAlTop of Prop
	(properties
		y 148
		x 102
		view 346
		loop 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 14 ignoreActors: stopUpd:)
	)
)

(instance aAl of View
	(properties
		y 191
		x 99
		view 346
		cel 1
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aLadyUL_Top of Prop
	(properties
		y 110
		x 45
		view 340
		loop 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance atpLadyUL_Bottom of PV
	(properties
		y 133
		x 45
		view 340
		cel 2
	)
)

(instance aLadyLR_Top of Prop
	(properties
		y 161
		x 289
		view 340
		loop 4
	)
	
	(method (init)
		(super init:)
		(self setPri: 14 setScript: drinkerScript stopUpd:)
	)
)

(instance atpLadyLR_Bottom of PV
	(properties
		y 183
		x 283
		view 340
		cel 4
	)
)

(instance aManUL_Top of Prop
	(properties
		y 110
		x 281
		view 340
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance atpManUL_Bottom of PV
	(properties
		y 132
		x 281
		view 340
		cel 1
	)
)

(instance talkCycler of Code
	(properties)
	
	(method (doit)
		(if (Random 0 3) (aComic cel: (Random 0 2)))
	)
)

(instance aComic of Act
	(properties
		y 58
		x 241
		view 343
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setScript: ComicScript setCycle: Walk stopUpd:)
	)
)

(instance aSign of Prop
	(properties
		y 50
		x 223
		view 340
		loop 5
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 3 stopUpd:)
	)
)
