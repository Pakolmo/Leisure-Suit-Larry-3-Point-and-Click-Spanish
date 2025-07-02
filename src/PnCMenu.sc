;;; Sierra Script 1.0 - (do not remove this comment)
(script# 950)
(include sci.sh)
(use Main)
(use Class_255_0)
(use rm500)
(use Gauge)
(use Cycle)
(use Game)
(use InvI)
(use Feature)
(use Obj)

(public
	PnCMenu 0
)

(local
	[local0 50]
	local50 =  4
	local51 =  50
	local52
	local53
	local54
	local55
	[local56 66]
	[local122 42] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -16564 5177 19666 27846 18175 19476 14668 -11668 -14778 -2049 -12039 -6221 -28275 -28200 -29441 -24077 -12441 8987 9137 6655]
	local164 =  500
	local165
	gEgoEdgeHit
	local167
	[local168 5]
)
(instance PnCMenu of Rgn
	(properties)
	
	(method (init)
		(super init:)
		(self setScript: PnCMenuScript)
		(switch global184
			(0
				(= global186 20)
				(walkIcon setPri: 15 y: global186 init:)
				(lookIcon setPri: 15 y: global186 init:)
				(handIcon setPri: 15 y: global186 init:)
				(talkIcon setPri: 15 y: global186 init:)
				(smellIcon setPri: 15 y: global186 init:)
				(invIcon setPri: 15 y: global186 init:)
				(blockIcon setPri: 15 y: global186 init:)
				(levelsIcon setPri: 15 y: global186 init:)
				(restartIcon setPri: 15 y: global186 init:)
				(saveIcon setPri: 15 y: global186 init:)
				(quitIcon setPri: 15 y: global186 init:)
				(if (!= gGCursorNumber 900)
					(selectedItem
						setPri: 15
						y: global186
						cel: gGCursorNumber
						init:
					)
				else
					(selectedItem setPri: 15 y: global186 cel: 0 init:)
				)
			)
			(2
				(= global186 189)
				(walkIcon setPri: 15 y: global186 init:)
				(lookIcon setPri: 15 y: global186 init:)
				(handIcon setPri: 15 y: global186 init:)
				(talkIcon setPri: 15 y: global186 init:)
				(smellIcon setPri: 15 y: global186 init:)
				(invIcon setPri: 15 y: global186 init:)
				(blockIcon setPri: 15 y: global186 init:)
				(levelsIcon setPri: 15 y: global186 init:)
				(restartIcon setPri: 15 y: global186 init:)
				(saveIcon setPri: 15 y: global186 init:)
				(quitIcon setPri: 15 y: global186 init:)
				(if (!= gGCursorNumber 900)
					(selectedItem
						setPri: 15
						y: global186
						cel: gGCursorNumber
						init:
					)
				else
					(selectedItem setPri: 15 y: global186 cel: 0 init:)
				)
			)
			(else 
				(walkIcon setPri: 15 y: global186 init:)
				(lookIcon setPri: 15 y: global186 init:)
				(handIcon setPri: 15 y: global186 init:)
				(talkIcon setPri: 15 y: global186 init:)
				(smellIcon setPri: 15 y: global186 init:)
				(invIcon setPri: 15 y: global186 init:)
				(blockIcon setPri: 15 y: global186 init:)
				(levelsIcon setPri: 15 y: global186 init:)
				(restartIcon setPri: 15 y: global186 init:)
				(saveIcon setPri: 15 y: global186 init:)
				(quitIcon setPri: 15 y: global186 init:)
				(if (!= gGCursorNumber 900)
					(selectedItem
						setPri: 15
						y: global186
						cel: gGCursorNumber
						init:
						setScript: showButtons
					)
				else
					(selectedItem
						setPri: 15
						y: global186
						cel: 0
						init:
						setScript: showButtons
					)
				)
			)
		)
	)
)

(instance PnCMenuScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== global184 1)
			(switch global187
				(0
					(cond 
						((or (== global186 0) (== global186 400)) (if (== local52 1) (= global186 0) (= global187 1)))
						((>= global186 20)
							(cond 
								((== local52 0) (= global187 2))
								((>= local54 local51) (= local53 0) (= local52 0) (= local54 0))
								(else (++ local54))
							)
						)
					)
				)
				(1
					(if (>= global186 20) (= global187 0))
				)
			)
		)
		(selectedItem loop: 2 cel: gGCursorNumber)
		(blockIcon loop: 2 cel: 0)
		(switch gCursorNumber
			(999
				(walkIcon loop: 1)
				(lookIcon loop: 0)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
			)
			(998
				(walkIcon loop: 0)
				(lookIcon loop: 1)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
			)
			(995
				(walkIcon loop: 0)
				(lookIcon loop: 0)
				(handIcon loop: 1)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
			)
			(996
				(walkIcon loop: 0)
				(lookIcon loop: 0)
				(handIcon loop: 0)
				(talkIcon loop: 1)
				(smellIcon loop: 0)
			)
			(994
				(walkIcon loop: 0)
				(lookIcon loop: 0)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 1)
			)
			(gGCursorNumber
				(walkIcon loop: 0)
				(lookIcon loop: 0 init:)
				(handIcon loop: 0)
				(talkIcon loop: 0)
				(smellIcon loop: 0)
			)
		)
		(if (!= gGCursorNumber 900)
			(selectedItem view: (+ gGCursorNumber 900))
		else
			(selectedItem view: 900)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(super handleEvent: pEvent)
		(= temp0 (HaveMouse))
		(if (== (pEvent type?) evMOUSEBUTTON)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(blockIcon setCel: gGCursorNumber)
			(if (& (pEvent modifiers?) emSHIFT)
				(if (== global97 1)
					(pEvent claimed: 1)
				else
					(pEvent claimed: 1)
					(= local54 0)
					(switch gCursorNumber
						(gGCursorNumber
							(gGame setCursor: 999 temp0)
						)
						(999
							(gGame setCursor: 998 temp0)
						)
						(996
							(gGame setCursor: 994 temp0)
						)
						(998
							(gGame setCursor: 995 temp0)
						)
						(995
							(gGame setCursor: 996 temp0)
						)
						(994
							(if
							(or (== gGCursorNumber 900) (== gGCursorNumber 993))
								(gGame setCursor: 999 temp0)
							else
								(gGame setCursor: gGCursorNumber temp0)
								(= gCursorNumber gGCursorNumber)
							)
						)
					)
				)
			)
			(if (not (& (pEvent modifiers?) emSHIFT))
				(cond 
					((== global97 1) (pEvent claimed: 1))
					((< (pEvent y?) 1)
						(pEvent type: 1 claimed: 1)
						(switch global187
							(0
								(if (== global184 1)
									(if (== local52 1) (= local52 0) else (= local52 1))
								)
							)
							(1
								(= global187 2)
								(= local52 0)
							)
							(2
								(= global187 1)
								(= local52 1)
							)
						)
					)
					(
						(and
							(> (pEvent x?) (walkIcon nsLeft?))
							(< (pEvent x?) (walkIcon nsRight?))
							(> (pEvent y?) (walkIcon nsTop?))
							(< (pEvent y?) (walkIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(gGame setCursor: 999 temp0)
					)
					(
						(and
							(> (pEvent x?) (talkIcon nsLeft?))
							(< (pEvent x?) (talkIcon nsRight?))
							(> (pEvent y?) (talkIcon nsTop?))
							(< (pEvent y?) (talkIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(gGame setCursor: 996 temp0)
					)
					(
						(and
							(> (pEvent x?) (lookIcon nsLeft?))
							(< (pEvent x?) (lookIcon nsRight?))
							(> (pEvent y?) (lookIcon nsTop?))
							(< (pEvent y?) (lookIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(gGame setCursor: 998 temp0)
					)
					(
						(and
							(> (pEvent x?) (handIcon nsLeft?))
							(< (pEvent x?) (handIcon nsRight?))
							(> (pEvent y?) (handIcon nsTop?))
							(< (pEvent y?) (handIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(gGame setCursor: 995 temp0)
					)
					(
						(and
							(> (pEvent x?) (smellIcon nsLeft?))
							(< (pEvent x?) (smellIcon nsRight?))
							(> (pEvent y?) (smellIcon nsTop?))
							(< (pEvent y?) (smellIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(gGame setCursor: 994 temp0)
					)
					(
						(and
							(> (pEvent x?) (invIcon nsLeft?))
							(< (pEvent x?) (invIcon nsRight?))
							(> (pEvent y?) (invIcon nsTop?))
							(< (pEvent y?) (invIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (and (== global184 1) (!= global187 2))
							(= global187 2)
							(= local52 0)
						)
						(= local54 0)
						(invIcon setScript: dotheinv)
					)
					(
						(and
							(> (pEvent x?) (selectedItem nsLeft?))
							(< (pEvent x?) (selectedItem nsRight?))
							(> (pEvent y?) (selectedItem nsTop?))
							(< (pEvent y?) (selectedItem nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(if (!= gGCursorNumber 900)
							(gGame setCursor: gGCursorNumber temp0)
							(= gCursorNumber gGCursorNumber)
						else
							(proc255_0 {Primero debes seleccionar un objeto.})
						)
					)
					(
						(and
							(> (pEvent x?) (levelsIcon nsLeft?))
							(< (pEvent x?) (levelsIcon nsRight?))
							(> (pEvent y?) (levelsIcon nsTop?))
							(< (pEvent y?) (levelsIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(invIcon setScript: dothelevels)
					)
					(
						(and
							(> (pEvent x?) (restartIcon nsLeft?))
							(< (pEvent x?) (restartIcon nsRight?))
							(> (pEvent y?) (restartIcon nsTop?))
							(< (pEvent y?) (restartIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(restartIcon setScript: dotherestart)
					)
					(
						(and
							(> (pEvent x?) (saveIcon nsLeft?))
							(< (pEvent x?) (saveIcon nsRight?))
							(> (pEvent y?) (saveIcon nsTop?))
							(< (pEvent y?) (saveIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(saveIcon setScript: dothesave)
					)
					(
						(and
							(> (pEvent x?) (quitIcon nsLeft?))
							(< (pEvent x?) (quitIcon nsRight?))
							(> (pEvent y?) (quitIcon nsTop?))
							(< (pEvent y?) (quitIcon nsBottom?))
						)
						(pEvent claimed: 1)
						(if (== global187 2) (= global187 1) (= local52 1))
						(= local54 0)
						(quitIcon setScript: dothequit)
					)
					(
						(and
							(> (pEvent x?) (gEgo nsLeft?))
							(< (pEvent x?) (gEgo nsRight?))
							(> (pEvent y?) (gEgo nsTop?))
							(< (pEvent y?) (gEgo nsBottom?))
						)
						(switch gCursorNumber
							(29
								(cond 
									((!= gGNumber_2 0) (proc0_9))
									((not (gEgo has: 13)) (proc0_12))
									((== ((Inv at: 13) view?) 28) (proc255_0 500 6 82 28 0 0))
									((>= gNumber 500)
										(proc0_6)
										(gGame changeScore: 20)
										(= global200 0)
										(gTheMusic number: 500 loop: global72 play:)
										(proc255_0 500 7 82 29 0 0)
										(proc255_0 500 8)
										(proc0_24 13)
										(proc0_1)
										(gEgo baseSetter: SteadyBase setCycle: SlowWalk)
										(= gGCursorNumber 900)
										(gGame setCursor: 998 (HaveMouse))
										(Bambu changeState: 0)
									)
								)
							)
							(15
								(cond 
									((proc0_23 15 484) (proc255_0 520 3))
									((proc0_23 15 -1) (proc0_12))
									((proc0_22 72) (proc255_0 520 4))
									((!= gGNumber_2 0) (proc0_9))
									(else (BambuRock changeState: 15))
								)
							)
							(11
								(cond 
									((== ((Inv at: 11) view?) 26) (proc255_0 0 30))
									((!= gGNumber_2 0) (proc0_9))
									(else
										(proc0_6)
										(gGame setScript: (ScriptID 42))
										(= gGCursorNumber 900)
										(gGame setCursor: 999)
									)
								)
							)
							(10
								(if (not (gEgo has: 9))
									(gEgo get: 9)
									(gGame changeScore: 100)
									(proc255_0 0 42)
								)
							)
							(9
								(proc0_6)
								(gGame setScript: (ScriptID 45))
							)
							(4
								(cond 
									((not (gEgo has: 4)) (proc255_0 0 34))
									((== ((Inv at: 4) view?) 23) (proc255_0 0 35))
									((!= gGNumber_2 0) (proc0_9))
									(else
										(proc0_6)
										(gGame setScript: (ScriptID 44))
										(= gGCursorNumber 900)
										(gGame setCursor: 999)
									)
								)
							)
							(999
								(pEvent type: 1 claimed: 0)
							)
							(997
								(pEvent type: 1 claimed: 0)
							)
							(998
								(pEvent type: 1 claimed: 1)
								(if global108
									(switch (Random 0 2)
										(0 (proc255_0 950 36))
										(1 (proc255_0 950 37))
										(2 (proc255_0 950 38))
									)
								else
									(switch (Random 0 2)
										(0 (proc255_0 950 10))
										(1 (proc255_0 950 11))
										(2 (proc255_0 950 12))
									)
								)
							)
							(996
								(pEvent type: 1 claimed: 1)
								(if global108
									(switch (Random 0 2)
										(0 (proc255_0 950 39))
										(1 (proc255_0 950 40))
										(2 (proc255_0 950 41))
									)
								else
									(switch (Random 0 2)
										(0 (proc255_0 950 13))
										(1 (proc255_0 950 14))
										(2 (proc255_0 950 15))
									)
								)
							)
							(995
								(pEvent type: 1 claimed: 1)
								(if global108
									(switch (Random 0 2)
										(0 (proc255_0 950 42))
										(1 (proc255_0 950 43))
										(2 (proc255_0 950 44))
									)
								else
									(switch (Random 0 2)
										(0 (proc255_0 950 16))
										(1 (proc255_0 950 17))
										(2 (proc255_0 950 18))
									)
								)
							)
							(else 
								(pEvent type: 1 claimed: 1)
								(if global108
									(switch (Random 0 2)
										(0 (proc255_0 950 45))
										(1 (proc255_0 950 46))
										(2 (proc255_0 950 47))
									)
								else
									(switch (Random 0 2)
										(0 (proc255_0 950 19))
										(1 (proc255_0 950 20))
										(2 (proc255_0 950 21))
									)
								)
							)
						)
					)
					(else
						(switch gCursorNumber
							(999
								(pEvent type: 1 claimed: 0)
							)
							(998
								(pEvent type: 1 claimed: 1)
								(switch gNumber
									(200
										(proc255_0 200 8)
										(proc255_0 200 4)
									)
									(210 (proc255_0 210 2))
									(206
										(proc255_0 206 6)
										(proc255_0 206 7)
									)
									(213 (proc255_0 213 29))
									(216
										(proc255_0 216 30)
										(proc255_0 216 31)
									)
									(220 (proc255_0 220 1))
									(230
										(proc255_0 230 14)
										(proc255_0 230 15)
									)
									(235 (proc255_0 235 3))
									(240 (proc255_0 240 5))
									(245 (proc255_0 245 4))
									(250 (proc255_0 250 13))
									(253 (proc255_0 253 12))
									(260
										(proc255_0 260 22)
										(proc255_0 260 23)
									)
									(266
										(proc255_0 266 2)
										(proc255_0 266 3)
									)
									(300 (proc255_0 300 8))
									(305
										(proc255_0 305 3)
										(proc255_0 305 4)
									)
									(310
										(proc255_0 310 6)
										(proc255_0 310 7 67 -1 144)
									)
									(320
										(proc255_0 320 13)
										(proc255_0 320 14)
									)
									(323 (proc255_0 323 40))
									(340 (proc255_0 340 38))
									(350 (proc255_0 350 26))
									(360 (proc255_0 360 23))
									(375 (proc255_0 375 19))
									(380 (proc255_0 380 16))
									(400 (proc255_0 400 1))
									(415
										(proc255_0 417 0)
										(proc255_0 417 1)
									)
									(416 (proc255_0 417 5))
									(420
										(proc255_0
											(Format
												@local0
												420
												19
												(if (== global104 2)
													{una preciosa mujer en bata}
												else
													{t|}
												)
											)
										)
									)
									(440
										(proc255_0 440 10)
										(proc255_0 440 11)
									)
									(460
										(proc255_0 460 10)
										(proc255_0 460 11)
									)
									(470
										(proc255_0 470 16)
										(proc255_0 470 17)
									)
									(480 (proc255_0 470 13))
									(500
										(proc255_0 500 9)
										(proc255_0 500 10)
									)
									(510
										(proc255_0 510 5)
										(proc255_0 510 6)
										(proc255_0 510 7)
										(proc255_0 510 8)
									)
									(520
										(proc255_0 520 18)
										(proc255_0 520 19)
									)
									(523 (proc255_0 523 4))
									(530 (proc255_0 530 33))
									(540
										(proc255_0 540 23)
										(proc255_0 540 24 67 -1 144)
									)
									(550 (proc255_0 550 19))
									(590 (proc255_0 590 18))
									(620 (proc255_0 620 12))
									(630
										(proc255_0 630 8)
										(if (== gGNumber_2 630) (proc255_0 630 9))
									)
								)
							)
							(996
								(pEvent type: 1 claimed: 1)
								(proc255_0 0 109 67 -1 144)
							)
							(995
								(pEvent type: 1 claimed: 1)
								(proc255_0 0 158)
							)
							(997
								(pEvent type: 1 claimed: 1)
							)
							(else 
								(pEvent type: 1 claimed: 1)
								(proc255_0 0 151)
							)
						)
					)
				)
			)
		)
	)
)

(instance SteadyBase of Code
	(properties)
	
	(method (doit)
		(gEgo brBottom: (+ (gEgo y?) 1))
		(gEgo brTop: (- (gEgo brBottom?) 2))
		(gEgo brLeft: (- (gEgo x?) 10))
		(gEgo brRight: (+ (gEgo x?) 10))
	)
)

(instance SlowWalk of Fwd
	(properties)
	
	(method (doit)
		(if
			(or
				(!= (client x?) (client xLast?))
				(!= (client y?) (client yLast?))
			)
			(super doit:)
		)
	)
)

(instance dothequit of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(quitIcon loop: 1)
				(= cycles 3)
			)
			(1
				(if
					(proc255_0
						950
						26
						80
						{Salir}
						33
						1
						81
						{ Salir_}
						1
						81
						{ Uups_}
						0
					)
					(= global4 1)
				else
					(quitIcon loop: 0)
				)
			)
		)
	)
)

(instance dothesave of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(= state newState)
		(switch state
			(0
				(saveIcon loop: 1)
				(= cycles 3)
			)
			(1
				(= temp0
					(proc255_0
						950
						30
						81
						{\n__SALVAR__\n_}
						1
						81
						{\n__CARGAR__\n_}
						2
					)
				)
				(switch temp0
					(0 (= cycles 1))
					(1
						(= global203 (gGame sel_333: global196))
						(gGame sel_333: global196)
						(proc0_19 0)
						(= global173 0)
						(= global174 0)
						(= cycles 1)
					)
					(2
						(gGame restore:)
						(gGame sel_333: global203)
						(= cycles 1)
					)
					(else 
						(if (proc0_22 3)
							(proc255_0 997 8 80 {^Ahora no, me duele la cabeza!})
						else
							(proc0_19 0)
							(= global173 0)
							(= global174 0)
						)
						(= cycles 1)
					)
				)
			)
			(2 (saveIcon loop: 0))
		)
	)
)

(instance dotherestart of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(restartIcon loop: 1)
				(= cycles 3)
			)
			(1
				(if
					(proc255_0
						997
						9
						80
						{Reiniciar}
						82
						57
						0
						global108
						33
						global26
						81
						{Reiniciar}
						1
						81
						{ Uups_}
						0
					)
					(gGame restart:)
				else
					(restartIcon loop: 0)
					(= newState 0)
				)
			)
		)
	)
)

(instance dothelevels of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 220] temp220 temp221)
		(= state newState)
		(switch state
			(0
				(levelsIcon loop: 1)
				(= cycles 3)
			)
			(1
				(= global198
					(proc255_6
						950
						33
						81
						{\n VELOCIDAD \n_}
						1
						81
						{\n VOLUMEN \n_}
						2
						81
						{\n INSULTO \n_}
						3
						81
						{\n AUTOSALVAR \n_}
						4
						81
						{\n ACERCA DE \n_}
						5
						81
						{\n COLORES \n_}
						6
						81
						{\n VOLVER \n_}
						0
					)
				)
				(switch global198
					(1 (= global193 1) (= state 9))
					(2
						(= global194 2)
						(= state 19)
					)
					(3 (= state 29))
					(4 (= state 39))
					(5 (= state 49))
					(6 (= state 59))
				)
				(= cycles 1)
			)
			(10
				(if (proc0_14 2048)
					(= global195
						((Gauge new:)
							description: (Format @temp0 950 34)
							text: {Velocidad de animaci>n}
							normal: 10
							higher: {R*pido}
							lower: {Lento}
							doit: (- 16 gNewSpeed)
						)
					)
					(gGame setSpeed: (- 16 global195))
					(DisposeScript 987)
				)
				(= state 99)
				(= cycles 1)
			)
			(20
				(if (proc0_14 2048)
					(= global196
						((Gauge new:)
							description: (Format @temp0 950 35)
							text: {Volumen de Sonido}
							normal: 15
							higher: {Alto}
							lower: {Bajo}
							doit: (gGame sel_333: global196)
						)
					)
					(DoSound sndVOLUME global196)
					(gGame sel_333: global196)
					(DisposeScript 987)
					(= state 99)
					(= cycles 1)
				)
			)
			(30
				(proc255_2
					(Format @temp0 global170)
					38
					{Introduce tu mayor insulto:}
				)
				(if (> (StrLen @temp0) 4) (Format global170 @temp0))
			)
			(40
				(if
					(>
						0
						(= global172
							(proc255_3 {Minutos Entre Recordatorios:} global172)
						)
					)
					(= global172 0)
				)
			)
			(50
				(proc255_0
					997
					14
					33
					global23
					30
					1
					80
					{Una Producci>n de Al Lowe}
					82
					51
					0
					0
				)
				(proc255_0
					(Format @temp0 997 15 global28)
					33
					global23
					30
					1
					80
					{El elenco de los miles}
					67
					-1
					30
					70
					234
				)
				(Format
					@global121
					997
					2
					(switch global88
						(4 {Totalmente obsceno})
						(3 {Realmente guarro})
						(2 {Bastante sucio})
						(1 {Algo arriesgado})
						(else  {Madre Ganso})
					)
				)
				(proc255_0
					(cond 
						(global69
							(Format
								@temp0
								997
								3
								@global121
								global69
								(if (== global69 1) {} else {s})
								global68
								(if (== global68 1) {} else {s})
								global67
								(if (== global67 1) {} else {s})
								global15
								(if (== global15 1) {} else {s})
							)
						)
						(global15
							(Format
								@temp0
								997
								4
								@global121
								global68
								(if (== global68 1) {} else {s})
								global67
								(if (== global67 1) {} else {s})
								global15
								(if (== global15 1) {} else {s})
							)
						)
						(else
							(Format
								@temp0
								997
								5
								@global121
								global68
								(if (== global68 1) {} else {s})
								global67
								(if (== global67 1) {} else {s})
							)
						)
					)
					33
					global23
					30
					1
					80
					{^B{scate una vida!}
				)
				(if (and global108 (== gNumber 500))
					(proc255_0
						{Mapa del bamb\{: ARRIBA, ARRIBA, DERECHA, DERECHA, ARRIBA, IZQUIERDA, ARRIBA, IZQUIERDA, ARRIBA, ARRIBA, ARRIBA, IZQUIERDA, IZQUIERDA, ABAJO, IZQUIERDA, IZQUIERDA, ARRIBA, ARRIBA, IZQUIERDA, ARRIBA.}
					)
				)
			)
			(60
				(= temp220 16)
				(while (and (u> temp220 15) (!= temp220 -1))
					(= temp220 (proc255_3 {Nuevo Color de Texto: (0-15)}))
				)
				(if (!= temp220 -1)
					(= temp221 16)
					(while
						(and
							(!= temp221 -1)
							(or (u> temp221 15) (== temp221 temp220))
						)
						(= temp221 (proc255_3 {Nuevo Color de Fondo: (0-15)}))
					)
					(if (!= temp221 -1)
						(= global105 temp220)
						(= global106 temp221)
					)
				)
				(gTheWindow color: global105 back: global106)
			)
			(100 (levelsIcon loop: 0))
		)
	)
)

(instance dotheinv of Script
	(properties)
	
	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(if (== global190 1)
					(= gGCursorNumber_2 gCursorNumber)
					(invIcon loop: 1)
					(= cycles 3)
				else
					(proc255_0 950 9)
				)
			)
			(1
				(= global191 1)
				(if (proc0_14 1024) (gInv showSelf: gEgo))
			)
		)
	)
)

(instance walkIcon of Prop
	(properties
		y 189
		x 14
		view 950
	)
)

(instance talkIcon of Prop
	(properties
		y 189
		x 98
		view 950
		cel 3
	)
)

(instance lookIcon of Prop
	(properties
		y 189
		x 42
		view 950
		cel 1
	)
)

(instance handIcon of Prop
	(properties
		y 189
		x 70
		view 950
		cel 2
	)
)

(instance smellIcon of Prop
	(properties
		y 189
		x 126
		view 950
		cel 4
	)
)

(instance invIcon of Prop
	(properties
		y 189
		x 152
		view 950
		cel 5
	)
)

(instance blockIcon of Prop
	(properties
		y 189
		x 186
		view 950
		loop 2
	)
)

(instance levelsIcon of Prop
	(properties
		y 189
		x 220
		view 950
		cel 6
	)
)

(instance restartIcon of Prop
	(properties
		y 189
		x 248
		view 950
		cel 7
	)
)

(instance saveIcon of Prop
	(properties
		y 189
		x 276
		view 950
		cel 8
	)
)

(instance quitIcon of Prop
	(properties
		y 189
		x 304
		view 950
		cel 9
	)
)

(instance selectedItem of Prop
	(properties
		y 189
		x 186
	)
)

(instance showButtons of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(switch global187
			(0)
			(1
				(if (< global186 20)
					(= global186 (+ global186 local50))
					(= local54 0)
				else
					(= global187 0)
					(= local53 1)
				)
			)
			(2
				(if (and (> global186 0) (< global186 400))
					(= global186 (- global186 local50))
				else
					(= global187 0)
					(= global186 400)
				)
			)
		)
		(walkIcon y: global186)
		(lookIcon y: global186)
		(handIcon y: global186)
		(talkIcon y: global186)
		(smellIcon y: global186)
		(invIcon y: global186)
		(blockIcon y: global186)
		(levelsIcon y: global186)
		(restartIcon y: global186)
		(saveIcon y: global186)
		(quitIcon y: global186)
		(if (!= gGCursorNumber 900)
			(selectedItem y: global186)
		else
			(selectedItem y: global186)
		)
	)
)

(instance BambuRock of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			(
			(and (& (gEgo onControl: 1) $0200) (== gGNumber_2 0)) (self changeState: 1))
			(
			(and (== gGNumber_2 1003) (< 8 (++ local167)))
				(= local167 0)
				(gEgo
					setLoop: (+ (Random 0 1) (* 2 (< (gEgo y?) 107)))
				)
			)
			(
			(and (& (gEgo onControl:) $0002) (== gGNumber_2 0)) (self changeState: 12))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if (!= gGNumber_2 1003)
					(= gGNumber_2 1003)
					(gTheSoundFX stop:)
					(gTheMusic number: 6 loop: -1 play:)
				)
				(proc0_3)
				(gEgo
					view: 812
					setLoop: 0
					setStep: 1 3
					setCycle: Fwd
					setPri: 8
					illegalBits: 0
				)
				(if (> (gEgo y?) 137)
					(gEgo posn: 58 (gEgo y?) setMotion: MoveTo 58 137 self)
				else
					(gEgo posn: (- (gEgo x?) 20) (gEgo y?))
					(self cue:)
				)
			)
			(2
				(if (> (gEgo y?) 100)
					(gEgo setMotion: MoveTo 86 100 self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo setMotion: MoveTo 105 83 self)
			)
			(4
				(= gGNumber_2 1001)
				(gTheSoundFX stop:)
				(gTheMusic number: 4 loop: 1 play:)
				(gEgo setPri: 2 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo setStep: 1 8 setMotion: MoveTo (gEgo x?) 180 self)
			)
			(6
				(proc0_5)
				(if global64
					(proc0_1)
					(= gGNumber_2 0)
					(gEgo posn: 178 100)
				else
					(gGame setScript: (ScriptID 40))
					((ScriptID 40)
						caller: 522
						register: (Format @local56 520 30)
						next: (Format @local122 520 31)
					)
				)
			)
			(7
				(proc0_3)
				(= gGNumber_2 3)
				(gEgo
					view: 511
					cycleSpeed: 2
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gEgo setLoop: 1 cel: 0 setCycle: Fwd)
				(= cycles
					(* 2 (gEgo cycleSpeed?) 4 (- (NumCels gEgo) 1))
				)
			)
			(9
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(10 (= seconds 3))
			(11
				(gGame changeScore: 42)
				(proc0_19 6)
				(proc0_1 1)
				(= gGNumber_2 0)
				(proc255_0 520 32)
			)
			(12
				(proc0_3)
				(proc255_0
					(Format @local56 520 33 global170)
					67
					-1
					10
					88
				)
				(= gGNumber_2 2)
				(gTheSoundFX stop:)
				(gTheMusic number: 4 loop: 1 play:)
				(gEgo
					view: 813
					setLoop: 0
					cel: 0
					illegalBits: 0
					ignoreActors:
					setPri: 2
					setCycle: End self
				)
			)
			(13
				(gEgo setStep: 1 8 setMotion: MoveTo (gEgo x?) 188 self)
				(if global64 (= state 5))
			)
			(14 (global2 newRoom: 525))
			(15
				(proc0_3)
				(proc0_6)
				(gGame changeScore: 15)
				(proc0_19 72)
				(gEgo
					view: 521
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(16
				(gEgo cel: 3 setCycle: Beg self)
			)
			(17 (proc0_1))
			(18
				(proc0_3)
				(proc0_6)
				(gGame changeScore: 40)
				(= gGNumber_2 13)
				(gEgo illegalBits: 0 setMotion: MoveTo 213 104 self)
			)
			(19
				(gEgo
					view: 521
					loop: 1
					cel: 0
					cycleSpeed: 1
					setPri: 10
					setCycle: End self
				)
			)
			(20 (= cycles 11))
			(21
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(22 (= cycles 11))
			(23
				(proc255_0 520 34 82 15 0 0 67 -1 10)
				(gEgo setLoop: 3 cel: 0 posn: 212 71 setCycle: End self)
			)
			(24
				(gEgo setPri: 2)
				(= cycles 5)
			)
			(25
				(gEgo
					setStep: 1 1
					setMotion: MoveTo (gEgo x?) (+ 30 (gEgo y?)) self
				)
			)
			(26
				(proc255_0 520 35 67 -1 10)
				(global2 newRoom: 525)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			(
				(or
					(Said 'get/drink,water')
					(Said 'drink')
					(Said 'drink/water')
				)
				(cond 
					((proc0_22 6) (proc255_0 520 0))
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0200)) (proc0_10))
					(else (self changeState: 7))
				)
			)
			((Said 'use,attach/bra')
				(cond 
					((not (gEgo has: 16)) (proc0_12))
					((!= gGNumber_2 0) (proc0_9))
					(else (proc255_0 520 1))
				)
			)
			((Said 'use/hose')
				(if (not (gEgo has: 15))
					(proc0_12)
				else
					(proc255_0 520 2)
				)
			)
			((Said 'drain,(off<get),(get<off)/hose')
				(cond 
					((proc0_23 15 484) (proc255_0 520 3))
					((proc0_23 15 -1) (proc0_12))
					((proc0_22 72) (proc255_0 520 4))
					((!= gGNumber_2 0) (proc0_9))
					(else (self changeState: 15))
				)
			)
			((Said '(backdrop<on),wear/hose')
				(cond 
					((proc0_23 15 484) (proc255_0 520 3))
					((proc0_23 15 -1) (proc0_12))
					((!= gGNumber_2 0) (proc0_9))
					((not (proc0_22 72)) (proc255_0 520 5))
					(else (proc255_0 520 6) (gGame changeScore: -15) (proc0_20 72))
				)
			)
			((Said 'attach/hose>')
				(cond 
					((not (gEgo has: 15)) (proc255_0 520 7))
					((not (proc0_22 72)) (proc255_0 520 8))
					((Said '//!*') (proc255_0 520 9))
					((not (Said '//boulder')) (proc255_0 520 10))
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0010)) (proc255_0 520 11))
					(else (self changeState: 18))
				)
				(pEvent claimed: 1)
			)
			((Said 'look>')
				(cond 
					((Said '/palm') (proc255_0 520 12))
					((Said '/creek') (proc255_0 520 13))
					((Said '/boulder,boob')
						(if (& (gEgo onControl:) $0010)
							(proc255_0 520 14)
						else
							(proc255_0 520 15)
						)
					)
					((Said '/ledge,cliff,canyon') (proc255_0 520 16))
					((Said '/cascade,cascade,water') (proc255_0 520 17) (proc255_0 520 18 67 -1 144))
					((Said '[/area]') (proc255_0 520 19))
				)
			)
			((Said '(up<climb),climb/boulder,arch') (proc255_0 520 20))
			(
				(or
					(Said '(climb,go)<(down,above)')
					(Said 'decrease/i')
				)
				(proc255_0 520 21)
			)
			((Said 'climb') (proc255_0 520 22) (proc255_0 520 23 67 -1 144))
			((Said 'drag,grasp,get/bush,hemp') (proc255_0 520 24))
			((Said 'get,use/palm') (proc255_0 520 25))
			((Said '/bush') (proc255_0 520 26))
			((Said '/arch') (proc255_0 520 27))
			((Said '/flower') (proc255_0 520 28))
			((Said 'jump') (proc255_0 520 29))
		)
	)
)

(instance Bambu of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (gEgo edgeHit?)
			(= gEgoEdgeHit (gEgo edgeHit?))
			(gEgo edgeHit: 0 illegalBits: 0)
			(gGame setCursor: global21 1)
			(proc0_3)
			(++ global200)
			(self changeState: 0)
			(cond 
				((< global200 8) (gEgo view: 800 moveSpeed: 0))
				((< global200 14)
					(gEgo view: 501 moveSpeed: 0)
					(if (!= 501 (gTheMusic number?)) (gTheMusic fade:))
				)
				((< global200 17)
					(gEgo view: 502 moveSpeed: 1)
					(if (!= 502 (gTheMusic number?)) (gTheMusic fade:))
				)
				((< global200 18)
					(gEgo view: 503 moveSpeed: 2)
					(if (!= 503 (gTheMusic number?)) (gTheMusic fade:))
				)
				(else (gEgo view: 503 moveSpeed: 3) (self changeState: 2))
			)
			(switch gEgoEdgeHit
				(1
					(if (== local165 1)
						(gTheMusic fade:)
						(if (not (proc0_22 37))
							(gGame changeScore: 100)
							(proc255_0 500 0)
							(proc255_0 500 1)
						)
						(global2 newRoom: 510)
						(return)
					else
						(= local165 (- local165 8))
					)
				)
				(3
					(if (== local165 68)
						(global2 newRoom: 245)
						(return)
					else
						(= local165 (+ local165 8))
					)
				)
				(2 (++ local165))
				(4 (-- local165))
			)
			(if (== local164 505)
				(= local164 500)
				(switch gEgoEdgeHit
					(1
						(gEgo posn: (Random 130 234) 187)
					)
					(3 (gEgo posn: 177 26))
					(2 (gEgo posn: 1 74))
					(else  (gEgo posn: 317 74))
				)
			else
				(= local164 505)
				(switch gEgoEdgeHit
					(1
						(gEgo posn: (Random 80 163) 187)
					)
					(3 (gEgo posn: 188 26))
					(2 (gEgo posn: 1 83))
					(else  (gEgo posn: 314 128))
				)
			)
			(proc500_1)
			(Animate (gCast elements?) 0)
			(gEgo illegalBits: -32768)
			(proc0_4)
			(gGame setCursor: global20 (HaveMouse))
			(return)
		)
		(if (== (GameIsRestarting) 2)
			(proc500_1)
			(Animate (gCast elements?) 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(cond 
					(
						(and
							(>= global200 8)
							(<= global200 13)
							(!= 501 (gTheMusic number?))
						)
						(gTheMusic number: 501 loop: global72 play:)
					)
					(
						(and
							(>= global200 14)
							(<= global200 16)
							(!= 502 (gTheMusic number?))
						)
						(gTheMusic number: 502 loop: global72 play:)
					)
					(
						(and
							(<= global200 18)
							(>= global200 17)
							(!= 503 (gTheMusic number?))
						)
						(gTheMusic number: 503 loop: global72 play:)
					)
				)
				(cond 
					((== global200 4) (proc255_0 500 13))
					((== global200 8) (proc255_0 500 14))
					((== global200 12) (proc255_0 500 15))
					((== global200 16)
						(proc255_0 500 16)
						(proc255_0 500 17)
						(proc255_0 500 18)
						(proc255_0 500 19)
					)
				)
			)
			(2 (= seconds 3))
			(3
				(proc255_0 500 20)
				(= seconds 3)
			)
			(4
				(proc255_0 500 21)
				(= seconds 3)
			)
			(5
				(proc0_3)
				(proc255_0 500 22)
				(gEgo
					illegalBits: 0
					setMotion: 0
					view: 504
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(6
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 505
					register: (Format @local56 500 23)
					next: (Format @local122 500 24)
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return (pEvent claimed?)))
		(return
			(cond 
				((Said 'get/bamboo') (proc255_0 500 2))
				((Said 'climb/bamboo') (proc255_0 500 3))
				((Said 'attack/bamboo') (proc255_0 500 4))
				((Said 'nightstand,(get,nightstand<up)') (proc255_0 500 5))
				(
					(or
						(Said 'sip/water')
						(Said 'get/drink<1')
						(Said 'use,drink,drain/water,beer,bottle')
					)
					(cond 
						((!= gGNumber_2 0) (proc0_9))
						((not (gEgo has: 13)) (proc0_12))
						((== ((Inv at: 13) view?) 28) (proc255_0 500 6 82 28 0 0))
						(else
							(proc0_6)
							(gGame changeScore: 20)
							(= global200 0)
							(gTheMusic number: 500 loop: global72 play:)
							(proc255_0 500 7 82 29 0 0)
							(proc255_0 500 8)
							(proc0_24 13)
							(proc0_1)
							(gEgo baseSetter: SteadyBase setCycle: SlowWalk)
							(self changeState: 0)
						)
					)
				)
				((Said 'look>')
					(cond 
						((Said '[/area]') (proc255_0 500 9) (proc255_0 500 10 67 -1 144))
						((Said '/bamboo')
							(proc255_0 500 11)
							(proc255_0 (Format @local56 500 12 global92) 67 -1 144)
							(++ global92)
						)
					)
				)
			)
		)
	)
)
