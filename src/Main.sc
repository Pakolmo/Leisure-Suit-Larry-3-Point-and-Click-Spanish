;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use Class_255_0)
(use n958)
(use Sound)
(use SysWindow)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	LSL3 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	proc0_18 18
	proc0_19 19
	proc0_20 20
	proc0_21 21
	proc0_22 22
	proc0_23 23
	proc0_24 24
	proc0_25 25
	proc0_26 26
	proc0_27 27
	proc0_28 28
)

(local
	gEgo
	gGame
	global2
	gNewSpeed =  6
	global4
	gCast
	gRegions
	gTimers
	gSounds
	gInv
	gAddToPics
	gNumber
	gGNumber
	gNewRoomNumber
	global14
	global15
	global16
	global17 =  7
	global18
	gCursorNumber
	global20 =  999
	global21 =  997
	global22 =  1
	global23 =  4
	global24
	gTheNewDialog
	global26 =  1
	global27 =  12
	global28 =  {x.yyy.zzz}
	gLocales
	global30
	global31
	global32
	global33
	global34
	global35
	global36
	global37
	global38
	global39
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50 =  10
	gPicAngle
	gFeatures
	gSFeatures
	global54
	global55
	global56
	gPicNumber =  -1
	global58
	gTheWindow
	global60 =  3
	global61
	global62
	global63
	global64
	gGNumber_2
	global66
	global67
	global68
	global69
	global70
	global71
	global72
	global73
	global74
	global75
	global76
	global77
	global78
	global79
	global80
	global81
	global82
	global83
	global84
	global85
	global86
	global87
	global88
	global89
	global90
	global91
	global92
	global93
	global94
	gTheMusic
	global96
	global97
	global98
	global99
	global100
	global101
	gGEgoX
	gGEgoY
	global104
	global105
	global106
	gADoor
	global108
	gTheSoundFX
	global110
	global111
	global112
	global113
	global114
	global115
	global116
	global117
	global118
	gGEgoLoop
	gGGNumber_2
	global121
	global122
	global123
	global124
	global125
	global126
	global127
	global128
	global129
	global130
	global131
	global132
	global133
	global134
	global135
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	global147
	global148
	global149
	global150
	global151
	global152
	global153
	global154
	global155
	global156
	global157
	global158
	global159
	global160
	global161
	global162
	global163
	global164
	global165
	global166
	global167
	global168
	global169
	global170
	global171
	global172
	global173
	global174
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	global183
	global184 =  1
	global185
	global186 =  400
	global187
	gGCursorNumber_2 =  999
	gGCursorNumber =  900
	global190 =  1
	global191
	global192
	global193
	global194
	global195
	global196 =  16
	global197
	global198
	global199
	global200
	global201
	global202
	global203
	global219
	global220
)
(procedure (proc0_1 param1 param2)
	(proc0_4)
	(gEgo edgeHit: 0)
	(switch argc
		(0
			(proc0_2
				gEgo
				(gEgo loop?)
				(if (> argc 1) param2 else global66)
			)
		)
		(1
			(proc0_2
				gEgo
				param1
				(if (> argc 1) param2 else global66)
			)
		)
		(2 (proc0_2 gEgo param1 param2))
	)
)

(procedure (proc0_2 param1 param2 param3)
	(if (> argc 1) (param1 loop: param2))
	(if (> argc 2) (param1 view: param3))
	(param1
		setLoop: -1
		setPri: -1
		setStep: 3 2
		setCycle: Walk
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
)

(procedure (proc0_3)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
)

(procedure (proc0_4)
	(User canControl: 1 canInput: 1)
	(gEgo setMotion: 0)
)

(procedure (proc0_5)
	(if gTheNewDialog (gTheNewDialog dispose:))
)

(procedure (proc0_6)
	(proc255_0 0 170)
)

(procedure (proc0_7)
	(proc255_0 0 171)
)

(procedure (proc0_8)
	(proc255_0 0 172)
)

(procedure (proc0_9)
	(proc255_0 0 173)
)

(procedure (proc0_10)
	(proc255_0 0 174)
)

(procedure (proc0_11)
	(proc255_0 0 175)
)

(procedure (proc0_12)
	(proc255_0 0 176)
)

(procedure (proc0_13 param1)
	(= param1 (ScriptID param1))
	(param1 notify: &rest)
)

(procedure (proc0_14 param1)
	(return
		(if (> (MemoryInfo 1) param1)
			(return 1)
		else
			(proc255_0 0 57)
			(return 0)
		)
	)
)

(procedure (proc0_15 param1)
	(if param1
		((View new:)
			view: (param1 view?)
			loop: (param1 loop?)
			cel: (param1 cel?)
			setPri: (param1 priority?)
			posn: (param1 x?) (param1 y?)
			addToPic:
		)
		(param1 posn: (param1 x?) (+ 1000 (param1 y?)))
	)
)

(procedure (proc0_16 param1 param2 param3)
	(= global74 param1)
	(= global73 (* 10 (+ param3 (* param2 60))))
)

(procedure (proc0_17 &tmp [temp0 70])
)

(procedure (proc0_18 &tmp [temp0 50])
	(proc0_17
		(Format
			@temp0
			{Lame response to "%s"}
			(User inputLineAddr?)
		)
	)
)

(procedure (proc0_19 param1)
	(= [global75 (/ param1 16)]
		(| [global75 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (proc0_20 param1)
	(= [global75 (/ param1 16)]
		(&
			[global75 (/ param1 16)]
			(~ (>> $8000 (mod param1 16)))
		)
	)
)

(procedure (proc0_21 param1)
	(= [global75 (/ param1 16)]
		(^ [global75 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (proc0_22 param1)
	(return
		(if
		(& [global75 (/ param1 16)] (>> $8000 (mod param1 16)))
			1
		else
			0
		)
	)
)

(procedure (proc0_23 param1 param2)
	(return
		(==
			((gInv at: param1) owner?)
			(if (< argc 2) gNumber else param2)
		)
	)
)

(procedure (proc0_24 param1 param2)
	((gInv at: param1)
		owner: (if (< argc 2) gNumber else param2)
	)
)

(procedure (proc0_25 param1)
	(return (+ 3 (/ (StrLen param1) global110)))
)

(procedure (proc0_26 param1 param2 param3)
	(if
		(and
			(<
				param2
				(+
					(param1 x?)
					(/
						(CelWide (param1 view?) (param1 loop?) (param1 cel?))
						2
					)
				)
			)
			(>
				param2
				(-
					(param1 x?)
					(/
						(CelWide (param1 view?) (param1 loop?) (param1 cel?))
						2
					)
				)
			)
			(< param3 (param1 y?))
			(>
				param3
				(-
					(param1 y?)
					(CelHigh (param1 view?) (param1 loop?) (param1 cel?))
				)
			)
		)
		(return)
	)
)

(procedure (proc0_27 param1 param2 param3 param4 param5)
	(return
		(if
			(and
				(> (param5 x?) param1)
				(< (param5 x?) param2)
				(> (param5 y?) param3)
				(< (param5 y?) param4)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(procedure (proc0_28 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(if (< argc 3)
		(= temp0 (param1 view?))
		(= temp1 (param1 loop?))
		(= temp2 (param1 cel?))
		(if (> argc 1) (= temp3 param2) else (= temp3 4))
		(Graph
			grDRAW_LINE
			(param1 y?)
			(+ (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			(param1 y?)
			(- (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			temp3
		)
		(Graph
			grDRAW_LINE
			(param1 y?)
			(+ (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			(- (param1 y?) (CelHigh temp0 temp1 temp2))
			(+ (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			temp3
		)
		(Graph
			grDRAW_LINE
			(- (param1 y?) (CelHigh temp0 temp1 temp2))
			(+ (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			(- (param1 y?) (CelHigh temp0 temp1 temp2))
			(- (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			temp3
		)
		(Graph
			grDRAW_LINE
			(- (param1 y?) (CelHigh temp0 temp1 temp2))
			(- (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			(param1 y?)
			(- (param1 x?) (/ (CelWide temp0 temp1 temp2) 2))
			temp3
		)
	else
		(= temp1 param1)
		(= temp4 param2)
		(= temp5 param3)
		(= temp6 param4)
		(if (> argc 4) (= temp3 param5) else (= temp3 4))
		(Graph grDRAW_LINE temp5 temp1 temp5 temp4 temp3)
		(Graph grDRAW_LINE temp5 temp4 temp6 temp4 temp3)
		(Graph grDRAW_LINE temp6 temp4 temp6 temp1 temp3)
		(Graph grDRAW_LINE temp6 temp1 temp5 temp1 temp3)
	)
)

(class Iitem of InvI
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
	)
	
	(method (showSelf)
		(proc255_0 30 view 80 name 82 view 0 0)
	)
)

(instance LSL3 of Game
	(properties)
	
	(method (init &tmp temp0)
		((= gTheWindow theWindow)
			color: (= global105 1)
			back: (= global106 15)
		)
		(super init:)
		(proc0_19 14)
		(= global171 {"Me llamo Larry; Larry Laffer."})
		(= global28 {1.021})
		(= global27 global196)
		(DoSound sndVOLUME global27)
		(SL code: statusCode)
		(TheMenuBar init:)
		(scoreSound owner: self init:)
		((= gTheMusic theMusic) owner: self init:)
		((= gTheSoundFX theSoundFX) owner: self init:)
		(User alterEgo: (= gEgo ego) blocks: 0 y: 150)
		(if (HaveMouse)
			(gGame setCursor: global20 1)
		else
			(gGame setCursor: global20 1 304 174)
		)
		(Load rsFONT (= global26 0))
		(Load rsFONT (= global22 1))
		(Load rsFONT (= global23 4))
		(Load rsFONT 999)
		(Load rsCURSOR global20)
		(Load rsCURSOR global21)
		(Load rsCURSOR 666)
		(Load rsCURSOR 992)
		(Inv
			add:
				Nothing
				Tarjeta_de_Cr_dito
				Cuchillo_Ginsu__
				Madera_de_Granadilla
				Hierba_Nativa_
				Jab_n
				Un_Billete_de_20_D_lares_
				Tierras__
				Toalla_de_Playa
				Tarjeta_de_Spa
				Divorcio______
				Algunas_Orqu_deas
				Llave_de__tico_
				Botella_de_Vino
				Panties
				Medias
				Sujetador
				Vestido
				Rotulador_M_gico
				Coco
				Marihuana
		)
		(if (GameIsRestarting)
			(= temp0 290)
		else
			(= temp0 120)
		)
		(self newRoom: temp0)
	)
	
	(method (doit &tmp [temp0 50])
		(super doit:)
		(if (proc0_22 0) (proc0_20 0) (gGame save:))
		(if global97 (User canControl: 0 canInput: 0))
		(if (!= global70 (= global70 (GetTime 1)))
			(if (>= (++ global67) 60)
				(= global67 0)
				(if (>= (++ global68) 60)
					(= global68 0)
					(++ global69)
				)
			)
			(++ global71)
			(if
				(and
					(< global15 20)
					(> global68 19)
					(> global71 8)
					(< global71 69)
					(User canControl:)
					(== global67 1)
				)
				(++ global67)
				(proc255_0 0 0)
				(proc255_0 0 1 67 -1 144)
			)
			(if
				(and
					(not (proc0_22 4))
					global172
					(>= (++ global174) 60)
				)
				(= global174 0)
				(if (>= (++ global173) global172)
					(= global173 0)
					(if
						(proc255_0
							(Format
								@temp0
								0
								2
								global172
								(if (== global172 1) {} else {s})
							)
							80
							{^Precaucion\05 Autosave!}
							82
							52
							0
							0
							33
							global26
							81
							{^Salvar Ahora!}
							1
							81
							{Que le den.}
							0
							67
							-1
							10
						)
						(gGame save:)
					)
				)
			)
		)
		(if (> global93 global15)
			(if (> global87 39)
				(-- global93)
			else
				(= global93 global15)
			)
			(SL doit:)
		)
		(if (< global93 global15)
			(if (> global87 39)
				(++ global93)
			else
				(= global93 global15)
			)
			(SL doit:)
		)
		(cond 
			((proc0_22 5) (self setCursor: 997 1))
			((== (User controls?) 0)
				(if (User canInput?)
					(self setCursor: 992 (HaveMouse))
				else
					(self setCursor: global21 (HaveMouse))
				)
			)
			((== gCursorNumber global21)
				(if (== gNumber 140)
					(self setCursor: 993 (HaveMouse))
				else
					(self setCursor: global20 (HaveMouse))
				)
			)
			(else (self setCursor: gCursorNumber (HaveMouse)))
		)
		(return (if (and global74 global73) (-- global73) else 0))
	)
	
	(method (replay)
		(TheMenuBar draw:)
		(SL enable:)
		(SetMenu
			1282
			26
			(if (DoSound sndSET_SOUND) {Turn Off} else {Turn On})
		)
		(super replay:)
	)
	
	(method (newRoom newRoomNumber param2)
		(if
			(or
				(and
					(not
						(proc999_5
							newRoomNumber
							200
							203
							210
							213
							216
							220
							230
							235
							240
							245
							250
							253
							300
							305
							310
						)
					)
					(proc999_5
						gNumber
						200
						203
						210
						213
						216
						220
						230
						235
						240
						245
						250
						253
						300
						305
						310
					)
				)
				(and
					(not (proc999_5 newRoomNumber 400 410 415 416 420 460))
					(proc999_5 gNumber 400 410 415 416 420 460)
				)
				(and
					(not (proc999_5 newRoomNumber 360 370 375 380 390))
					(proc999_5 gNumber 360 370 375 380 390)
				)
				(and
					(not (proc999_5 newRoomNumber 510 520 523 540 550))
					(proc999_5 gNumber 510 520 523 540 550)
				)
				(and
					(not (proc999_5 newRoomNumber 610 620 630 640 650))
					(proc999_5 gNumber 610 620 630 640 650)
				)
			)
			(gTheMusic fade:)
		)
		(proc0_20 3)
		(proc0_20 5)
		(proc0_5)
		(Load rsFONT global26)
		(Load rsFONT global22)
		(Load rsFONT global23)
		(Load rsFONT 999)
		(Load rsCURSOR global20)
		(Load rsCURSOR global21)
		(Load rsCURSOR 666)
		(Load rsCURSOR 992)
		(super newRoom: newRoomNumber)
		(= global71 0)
		(if (< argc 2)
			(= global17 (Random 0 5))
		else
			(= global17 param2)
		)
	)
	
	(method (startRoom param1)
		(proc958_0 0 993 991 988 981 973 971 969 967 21 50 51)
		(DisposeScript 958)
		(if global14 (= global14 0) (SetDebug))
		(gTheSoundFX stop: number: 1)
		(super startRoom: param1 &rest)
		(if
		(and (not (proc999_5 param1 530 260 420)) global64)
			(global2 setLocales: 20)
		)
		(if (proc0_22 14) (global2 setLocales: 22))
		(if (>= param1 200) (global2 setRegions: 950))
		(cond 
			(
				(proc999_5
					param1
					200
					203
					210
					213
					216
					220
					230
					235
					240
					245
					250
					253
					300
					305
					310
				)
				(global2 setLocales: 299)
			)
			((proc999_5 param1 360 370 375 380 390) (global2 setLocales: 399))
			((proc999_5 param1 400 410 415 416 420 460) (global2 setLocales: 499))
			((proc999_5 param1 510 520 523 540 550) (global2 setLocales: 599))
			((proc999_5 param1 610 620 630 640 650) (global2 setLocales: 699))
		)
		(if (or (== gGNumber_2 11) (== global66 708))
			(gEgo baseSetter: NormalBase)
		)
	)
	
	(method (changeScore param1)
		(= global15 (+ global15 param1))
		(if (> param1 0) (scoreSound playMaybe:))
	)
	
	(method (handleEvent pEvent &tmp [temp0 2] temp2 [temp3 3] [temp6 50])
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'ascot/backdrop')
				(if (= global64 (^ global64 $0001))
					(proc255_0 0 14)
				else
					(proc255_0 0 15)
				)
			)
			(
			(or (Said 'caress/ginsu') (Said 'sharpen/ginsu'))
				(cond 
					((not (gEgo has: 2)) (proc0_12))
					((== (Cuchillo_Ginsu__ view?) 21) (proc0_7))
					((!= gNumber 250) (proc255_0 0 16))
				)
			)
			(
			(or (Said 'backdrop/*/bottle') (Said 'fill/bottle')) (proc255_0 0 17))
			((Said '(drain<out),drain/beer,bottle')
				(cond 
					((not (gEgo has: 13)) (proc0_12))
					((not global108) (proc255_0 0 18))
					((== (Botella_de_Vino view?) 28) (proc255_0 0 19))
					(else
						(Botella_de_Vino view: 28)
						(Format (Botella_de_Vino name?) 0 20)
						(proc255_0 0 21)
					)
				)
			)
			((Said 'carve,carve>')
				(cond 
					((not (gEgo has: 2)) (proc255_0 0 22))
					((== (Cuchillo_Ginsu__ view?) 2) (proc255_0 0 23))
					((Said '[/!*]') (proc255_0 0 24))
					((Said '/blade') (proc255_0 0 25))
					((not (Said '/carving,granadilla')) (proc255_0 0 26))
					((not (gEgo has: 3)) (proc255_0 0 27))
					(
						(or
							(== (Madera_de_Granadilla view?) 22)
							(== (Madera_de_Granadilla view?) 34)
						)
						(proc255_0 0 28)
					)
					((or (== gGNumber_2 0) (== gGNumber_2 10)) (proc0_6) (gGame setScript: (ScriptID 43)))
					(else (proc0_9))
				)
				(pEvent claimed: 1)
			)
			(
				(or
					(Said 'use/flower/lei<make')
					(Said 'weave,make/flower,lei')
				)
				(cond 
					((not (gEgo has: 11)) (proc255_0 0 29))
					((== (Algunas_Orqu_deas view?) 26) (proc255_0 0 30))
					((!= gGNumber_2 0) (proc0_9))
					(else (proc0_6) (gGame setScript: (ScriptID 42)))
				)
			)
			(
			(Said 'wear,(alter<in),(backdrop<on)/flower,lei')
				(cond 
					((not (gEgo has: 11)) (proc255_0 0 31))
					((!= (Algunas_Orqu_deas view?) 26) (proc255_0 0 32))
					((!= gGNumber_2 0) (proc0_9))
					(else (proc255_0 0 33))
				)
			)
			(
				(or
					(Said 'use/blade/skirt<make')
					(Said 'weave,make/blade,skirt')
				)
				(cond 
					((not (gEgo has: 4)) (proc255_0 0 34))
					((== (Hierba_Nativa_ view?) 23) (proc255_0 0 35))
					((!= gGNumber_2 0) (proc0_9))
					(else (proc0_6) (gGame setScript: (ScriptID 44)))
				)
			)
			(
				(or
					(Said 'get/naked')
					(Said '(get<off),drain/cloth,cloth')
				)
				(proc255_0 0 36)
			)
			((Said 'alter/cloth,cloth') (proc255_0 0 37))
			(
			(Said 'wear,(alter<in),(backdrop<on)/blade,skirt')
				(cond 
					((not (gEgo has: 4)) (proc255_0 0 31))
					((not (== (Hierba_Nativa_ view?) 23)) (proc255_0 0 38))
					(else (proc255_0 0 39))
				)
			)
			((and (gEgo has: 5) (Said 'use/soap')) (proc255_0 0 40))
			(
				(or
					(Said 'unknownnumber/')
					(Said '/unknownnumber')
					(Said '//unknownnumber')
				)
				(proc255_0 0 41)
			)
			(
				(and
					(gEgo has: 10)
					(not (gEgo has: 9))
					(Said 'look,look/decree,document,document')
				)
				(gEgo get: 9)
				(gGame changeScore: 100)
				(proc255_0 0 42)
			)
			(
				(and
					(gEgo has: 9)
					(or
						(Said 'look<back/keycard,card')
						(Said 'look/back/keycard,card')
						(Said 'drag/keycard,card')
						(Said 'look/combination/keycard,card')
					)
				)
				(proc0_6)
				(gGame setScript: (ScriptID 45))
			)
			((Said 'count>')
				(= temp2 (gInv saidMe:))
				(cond 
					((Said '[/!*]') (proc255_0 0 43))
					((not temp2) (pEvent claimed: 1) (proc255_4 0 44 (Random 10 999)))
					((!= (gInv indexOf: temp2) 6) (proc255_0 0 45))
					((not (temp2 ownedBy: gEgo)) (proc255_0 0 46))
					(else (proc255_4 0 47 global94))
				)
			)
			((or (Said 'give/bill,buck') (Said 'bribe'))
				(cond 
					((not (gEgo has: 6)) (proc255_0 0 48))
					((== (Un_Billete_de_20_D_lares_ view?) 24)
						(proc255_0 0 49 82 (Un_Billete_de_20_D_lares_ view?) 0 0)
						(proc255_0 0 50 67 -1 144)
					)
					((== (Un_Billete_de_20_D_lares_ view?) 25)
						(proc255_0 0 51 82 (Un_Billete_de_20_D_lares_ view?) 0 0)
						(proc255_0 0 52)
					)
					(else
						(proc255_0 0 53 82 (Un_Billete_de_20_D_lares_ view?) 0 0)
						(proc255_0 0 54)
					)
				)
			)
			(
				(and
					(gEgo has: 4)
					(== (Hierba_Nativa_ view?) 23)
					(or
						(Said 'get/dress')
						(Said 'get<dress')
						(Said
							'wear,alter,(get<off),drain,(backdrop<on)/skirt,cloth,cloth'
						)
					)
				)
				(proc255_0 0 55)
			)
			((and (gEgo has: 16) (Said 'backdrop//(bra)>'))
				(= temp2 (gInv saidMe:))
				(cond 
					((Said '[/!*]') (proc255_0 0 56))
					((not temp2) (pEvent claimed: 1) (proc255_0 0 57))
					((not (temp2 ownedBy: gEgo)) (proc0_12))
					(else (proc255_0 0 58 82 16 0 0) (proc255_0 0 59 67 -1 144))
				)
			)
			(
				(and
					(gEgo has: 2)
					(or (Said 'use/ginsu') (Said 'attack'))
				)
				(proc255_0 0 60)
			)
			((Said 'open,(look<in)>')
				(= temp2 (gInv saidMe:))
				(cond 
					((Said '[/!*]') (proc255_0 0 61))
					((not temp2) (pEvent claimed: 1) (proc255_0 0 57))
					((not (temp2 ownedBy: gEgo)) (proc255_0 0 62))
					(else
						(switch (gInv indexOf: temp2)
							(11 (proc255_0 0 63 82 11 0 0))
							(13
								(switch (Botella_de_Vino view?)
									(28 (proc255_0 0 64 82 28 0 0))
									(29 (proc255_0 0 65 82 29 0 0))
									(else 
										(proc255_0 0 66 82 13 0 0)
									)
								)
							)
							(14 (proc255_0 0 67 82 14 0 0))
							(15 (proc255_0 0 68 82 15 0 0))
							(16 (proc255_0 0 69 82 16 0 0))
							(17 (proc255_0 0 70 82 17 0 0))
							(19 (proc255_0 0 71 82 19 0 0))
							(else 
								(proc255_0 0 62)
								(proc0_18)
							)
						)
					)
				)
			)
			((Said 'hello') (proc255_0 0 72))
			((or (Said '/bye') (Said 'bye')) (proc255_0 0 15))
			((Said 'thank') (proc255_0 0 73))
			((Said 'knock')
				(proc255_0 0 74)
				(proc255_0 (Format @temp6 0 75 global82) 67 -1 144)
			)
			((Said 'attack') (proc255_0 0 60))
			(
				(or
					(Said 'go/bathroom')
					(Said 'leak')
					(Said 'get/leak')
				)
				(if global108
					(proc255_0 0 76)
					(proc255_0 0 77 67 -1 144)
				else
					(proc255_0 0 78)
				)
			)
			((Said 'climb>')
				(cond 
					((Said '/wall,building') (proc255_0 0 79))
					(global108 (proc255_0 0 80))
					(else (proc255_0 0 81))
				)
				(pEvent claimed: 1)
			)
			((or (Said '//larry') (Said '/larry'))
				(cond 
					((not global108) (proc255_0 0 82))
					((< gNumber 590) (proc255_0 0 83))
					(else (proc255_0 0 84))
				)
			)
			((Said 'jump,dance') (proc255_0 0 85))
			((Said 'sing') (proc255_0 0 86))
			((Said 'delay') (proc255_0 0 87))
			((Said 'pick') (proc255_0 0 88))
			((Said 'holler') (proc255_0 0 89))
			((Said 'rob') (proc255_0 0 90))
			((or (Said 'n') (Said 'affirmative')) (proc0_6))
			((Said 'borrow') (proc255_0 0 91))
			((Said 'cheat')
				(proc255_0 0 92)
				(proc255_0 0 93 67 -1 144)
				(= global4 1)
			)
			((Said '(backdrop<on),wear>')
				(cond 
					((Said '[/!*]') (proc255_0 0 94))
					((= temp2 (gInv saidMe:))
						(cond 
							((not (gEgo has: (gInv indexOf: temp2))) (proc0_12))
							(
								(or
									(== temp2 16)
									(== temp2 17)
									(== temp2 14)
									(== temp2 15)
								)
								(proc0_8)
							)
							(else (proc255_0 0 95))
						)
					)
					(else (proc255_0 0 96) (pEvent claimed: 1))
				)
			)
			((Said 'backdrop>')
				(cond 
					((Said '[/!*]') (proc255_0 0 97))
					((= temp2 (gInv saidMe:))
						(if (not (gEgo has: (gInv indexOf: temp2)))
							(proc0_12)
						else
							(proc255_0 0 98)
						)
					)
					(else (proc255_0 0 99) (pEvent claimed: 1))
				)
			)
			((Said 'throw>')
				(cond 
					((Said '[/!*]') (proc255_0 0 100))
					((= temp2 (gInv saidMe:))
						(if (not (gEgo has: (gInv indexOf: temp2)))
							(proc0_12)
						else
							(proc255_0 0 101)
						)
					)
					(else (proc255_0 0 102) (pEvent claimed: 1))
				)
			)
			((Said 'smell')
				(proc255_0 0 103)
				(cond 
					((proc0_22 8) (proc255_0 0 104))
					((proc0_22 10) (proc255_0 0 105))
					((proc0_22 62) (proc255_0 0 106))
				)
			)
			((Said 'whistle') (proc255_0 0 107))
			((Said 'ask/job') (proc255_0 0 108) (proc255_0 0 109 67 -1 144))
			(
			(and global108 (or (Said '/arnold') (Said '//arnold'))) (proc255_0 0 110))
			((Said 'laugh') (proc255_0 0 111))
			((Said 'eat') (proc255_0 0 112))
			((Said 'lie,lie') (proc255_0 0 113))
			((Said 'aid/i,self') (proc255_0 0 114))
			((Said 'aid') (proc255_0 0 115))
			((Said 'explore>')
				(if (Said '/cloth,panties,entertainer,larry')
					(proc255_0 0 116)
					(gInv showSelf: gEgo)
					Inv
				else
					(pEvent claimed: 1)
					(proc255_0 0 117)
				)
			)
			((or (Said '/bang/ya') (Said 'bang/ya')) (proc255_0 0 118))
			((Said 'bang/*') (proc255_0 0 119))
			(
			(or (Said 'caress/i,larry,self') (Said 'jack')) (proc255_0 0 120))
			((Said 'caress,caress,embrace,look/clit') (proc255_4 0 121 global82))
			((Said 'eat/babe') (proc255_0 0 122))
			(
			(or (Said 'look<in/blouse') (Said 'look<up/skirt')) (proc255_0 0 123))
			((Said 'drink') (proc255_0 0 124))
			((or (Said 'use/key') (Said 'unbolt')) (proc255_0 0 125))
			((or (Said '/book') (Said '//book')) (proc255_0 0 126))
			((Said 'hear') (proc255_0 0 127))
			((Said 'embrace') (proc255_0 0 128))
			(
				(or
					(Said 'eat,bang/i')
					(Said 'crap,leak,bang,fart')
					(Said '/clit,crap,leak,bang,fart,asshole')
					(Said '//clit,crap,leak,bang,fart,asshole')
				)
				(proc255_0 0 129)
			)
			((or (Said '/hell') (Said '//hell')) (proc255_0 0 130))
			((Said 'look>')
				(cond 
					(
					(Said '/self,larry,entertainer,i,blouse,cloth,panties')
						(if (not global108)
							(proc255_0 0 131)
						else
							(proc255_0 0 132)
						)
					)
					(
					(and (== (gEgo view?) 718) (Said '/sunglass')) (proc255_0 0 133))
					((Said '/ankle,sandal')
						(if (== (gEgo view?) 718)
							(proc255_0 0 134)
						else
							(proc255_0 0 135)
						)
					)
					((Said '/bush,palm') (proc255_0 0 136))
					((Said '/man,babe,couple') (proc255_0 0 137))
					((Said '/wall,building') (proc255_0 0 138))
					((Said '/carpet,down') (proc255_0 0 139))
					((Said '/air,ceiling') (proc255_0 0 140))
					((Said '/boob') (if global108 (proc255_0 0 141) else (proc255_0 0 142)))
					((Said '/ass') (if global108 (proc255_0 0 143) else (proc255_0 0 144)))
					((Said '<in/cup') (proc255_0 0 145))
					((= temp2 (gInv saidMe:))
						(if (temp2 ownedBy: gEgo)
							(temp2 showSelf:)
						else
							(proc255_0 0 62)
						)
					)
					(else
						(switch (Random 42 44)
							(42 (proc255_0 0 146))
							(43 (proc255_0 0 147))
							(44 (proc255_0 0 62))
						)
						(pEvent claimed: 1)
						(proc0_18)
					)
				)
			)
			(
			(or (Said 'use,buy/bill,tips,buck') (Said 'buy'))
				(if (gEgo has: 6)
					(proc255_0 0 148)
				else
					(proc255_0 0 149)
				)
			)
			((Said 'use>')
				(= temp2 (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((Said '[/!*]') (proc255_0 0 150))
					((not temp2) (proc255_0 0 57))
					((not (temp2 ownedBy: gEgo)) (proc0_12))
					(else (proc255_0 0 151) (proc0_18))
				)
				(pEvent claimed: 1)
			)
			((Said 'give>')
				(= temp2 (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((Said '/*[/!*]') (proc255_0 0 152))
					((Said '[/!*]') (proc255_0 0 153))
					((not temp2) (proc255_0 0 154))
					((not (temp2 ownedBy: gEgo)) (proc0_12))
					(else (proc255_0 0 155) (proc0_18))
				)
				(pEvent claimed: 1)
			)
			((Said 'get<down') (proc255_0 0 156))
			((Said 'get<up') (proc255_0 0 157))
			((Said 'get>')
				(cond 
					((Said '[/!*]') (proc255_0 0 158))
					(
					(and (= temp2 (gInv saidMe:)) (temp2 ownedBy: gEgo)) (proc255_0 0 159))
					((== temp2 3) (proc255_0 0 160))
					(else
						(switch (Random 33 35)
							(33 (proc255_0 0 161))
							(34 (proc255_0 0 162))
							(35 (proc255_0 0 163))
						)
						(proc0_18)
					)
				)
				(pEvent claimed: 1)
			)
			((= temp2 (gInv saidMe:))
				(if (not (temp2 ownedBy: gEgo))
					(proc0_12)
				else
					(proc255_0 0 164)
				)
			)
			((Said 'address>')
				(if (Said '[/!*]')
					(proc255_0 0 152)
				else
					(proc255_0 0 165)
					(proc255_0 0 109 67 -1 144)
					(pEvent claimed: 1)
				)
			)
			(
				(or
					(Said '/clit,crap,leak,bang,asshole,boob,ass,asshole')
					(Said '//clit,crap,leak,bang,asshole,boob,ass,asshole')
				)
				(proc255_0 0 166)
			)
			(
			(or (Said '//babe') (Said '/babe/') (Said '/babe')) (proc255_0 0 167))
		)
	)
	
	(method (wordFail param1 &tmp [temp0 50])
		(switch (Random 0 4)
			(0
				(proc255_0 (Format @temp0 0 3 param1))
			)
			(1
				(proc255_0 (Format @temp0 0 4 param1))
			)
			(2
				(proc255_0 (Format @temp0 0 5 param1))
			)
			(3
				(proc255_0 (Format @temp0 0 6 param1))
			)
			(else 
				(proc255_0 (Format @temp0 0 7 param1))
			)
		)
	)
	
	(method (syntaxFail &tmp [temp0 40])
		(switch (Random 0 2)
			(0 (proc255_0 0 8))
			(1 (proc255_0 0 9))
			(else  (proc255_0 0 10))
		)
	)
	
	(method (pragmaFail &tmp [temp0 40])
		(switch (Random 0 2)
			(0 (proc255_0 0 11))
			(1 (proc255_0 0 12))
			(else  (proc255_0 0 13))
		)
	)
)

(instance Nothing of Iitem
	(properties)
)

(instance Tarjeta_de_Cr_dito of Iitem
	(properties
		view 1
		name "Tarjeta_de_Cr+dito"
	)
	
	(method (saidMe)
		(return
			(if (gEgo has: 9)
				(return 0)
			else
				(return (Said '/card[<credit]'))
			)
		)
	)
)

(instance Cuchillo_Ginsu__ of Iitem
	(properties
		said '/ginsu'
		view 2
		name "Cuchillo_Ginsu__"
	)
)

(instance Madera_de_Granadilla of Iitem
	(properties
		view 3
		name "Madera_de_Granadilla"
	)
	
	(method (saidMe)
		(if (== view 22)
			(Said '/granadilla,carving')
			(return)
		else
			(Said '/granadilla')
			(return)
		)
	)
)

(instance Hierba_Nativa_ of Iitem
	(properties
		owner 230
		view 4
		name "Hierba_Nativa_"
	)
	
	(method (saidMe)
		(if (== view 23)
			(Said '/skirt')
			(return)
		else
			(Said '/blade')
			(return)
		)
	)
)

(instance Jab_n of Iitem
	(properties
		said '/soap'
		owner 253
		view 5
		name "Jab>n"
	)
)

(instance Un_Billete_de_20_D_lares_ of Iitem
	(properties
		view 6
		name "Un_Billete_de_20_D>lares_"
	)
	
	(method (saidMe)
		(cond 
			((== view 24) (Said '/buck') (return))
			((== view 25) (Said '/buck,tips,jar') (return))
			(else (Said '/buck,bill') (return))
		)
	)
)

(instance Tierras__ of Iitem
	(properties
		said '/deed'
		view 7
		name "Tierras__"
	)
)

(instance Toalla_de_Playa of Iitem
	(properties
		said '/towel'
		view 8
		name "Toalla_de_Playa"
	)
)

(instance Tarjeta_de_Spa of Iitem
	(properties
		said '/keycard,card'
		view 9
		name "Tarjeta_de_Spa"
	)
)

(instance Divorcio______ of Iitem
	(properties
		said '/decree,decree'
		view 10
		name "Divorcio______"
	)
)

(instance Algunas_Orqu_deas of Iitem
	(properties
		owner 235
		view 11
		name "Algunas_Orqu|deas"
	)
	
	(method (saidMe)
		(if (== view 26)
			(Said '/flower,lei')
			(return)
		else
			(Said '/flower')
			(return)
		)
	)
)

(instance Llave_de__tico_ of Iitem
	(properties
		said '/key'
		owner 450
		view 12
		name "Llave_de_*tico_"
	)
)

(instance Botella_de_Vino of Iitem
	(properties
		view 13
		name "Botella_de_Vino"
	)
	
	(method (saidMe)
		(cond 
			((== view 28) (Said '/bottle') (return))
			((== view 29) (Said '/bottle,water') (return))
			(else (Said '/bottle,beer') (return))
		)
	)
)

(instance Panties of Iitem
	(properties
		said '/panties'
		owner 484
		view 14
	)
)

(instance Medias of Iitem
	(properties
		said '/hose'
		owner 484
		view 15
	)
)

(instance Sujetador of Iitem
	(properties
		said '/bra'
		owner 484
		view 16
	)
)

(instance Vestido of Iitem
	(properties
		said '/dress'
		owner 484
		view 17
	)
)

(instance Rotulador_M_gico of Iitem
	(properties
		said '/marker'
		view 18
		name "Rotulador M*gico"
	)
)

(instance Coco of Iitem
	(properties
		said '/coconut'
		owner 530
		view 19
	)
)

(instance Marihuana of Iitem
	(properties
		said '/dope,dope'
		owner 530
		view 20
	)
	
	(method (saidMe)
		(if (== view 27)
			(Said '/dope,hemp')
			(return)
		else
			(Said '/dope')
			(return)
		)
	)
)

(instance statusCode of Code
	(properties)
	
	(method (doit param1)
		(Format
			param1
			0
			168
			global93
			0
			169
			(if global108
				{Passionate Patti PnC}
			else
				{Leisure Suit Larry 3 PnC}
			)
		)
	)
)

(instance ego of Ego
	(properties
		y 1111
		view 700
	)
)

(instance scoreSound of Sound
	(properties
		number 1
		priority 10
	)
)

(instance theMusic of Sound
	(properties
		number 1
	)
)

(instance theSoundFX of Sound
	(properties
		number 1
		priority 5
	)
)

(instance theWindow of SysWindow
	(properties)
	
	(method (open)
		(if (< (Graph grGET_COLOURS) 9)
			(if (or (< color 7) (== color 8))
				(= color 0)
				(= back 15)
			else
				(= color 15)
				(= back 0)
			)
		)
		(super open:)
	)
)

(instance NormalBase of Code
	(properties)
	
	(method (doit &tmp temp0)
		(if (== gNumber 253) (= temp0 22) else (= temp0 10))
		(gEgo brBottom: (+ (gEgo y?) 1))
		(gEgo brTop: (- (gEgo brBottom?) (gEgo yStep?)))
		(gEgo brLeft: (- (gEgo x?) temp0))
		(gEgo brRight: (+ (gEgo x?) temp0))
	)
)
