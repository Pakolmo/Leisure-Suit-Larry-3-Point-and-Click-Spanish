;;; Sierra Script 1.0 - (do not remove this comment)
(script# 390)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm390 0
)
(synonyms
	(babe bambi dale)
)

(local
	local0
	[local1 200]
)
(procedure (localproc_001a)
	(proc0_5)
	(proc255_0
		@local1
		67
		10
		10
		80
		{Bambi dice...}
		70
		140
		30
		1
		88
	)
)

(procedure (localproc_0040)
	(proc0_5)
	(proc255_0 @local1 67 160 10 80 {Dices...} 70 140 30 1 88)
)

(instance rm390 of Rm
	(properties
		picture 390
	)
	
	(method (init)
		(aMike init:)
		(super init:)
		(if
		(and (not (proc0_22 52)) (not (proc0_22 53)))
			(aMonitorRight init:)
			(aMonitorLeft init:)
			(aBambi init:)
		)
		(self setScript: RoomScript)
		(if (== gGNumber 395)
			(gEgo posn: 135 155 loop: 2)
			(if (!= gGNumber_2 1)
				(= gGNumber_2 0)
			else
				(gTheMusic stop:)
				(Load rsVIEW 392)
				(Load rsVIEW 393)
				(Load rsVIEW 397)
				(Load rsSOUND 390)
				(aBambi setScript: 0)
				(RoomScript changeState: 1)
			)
		else
			(gEgo posn: 243 134 setLoop: 1)
		)
		(if (!= gGNumber_2 1)
			(proc0_1)
			(if (gCast contains: aBambi)
				(BambiScript changeState: 1)
			)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (< (gEgo priority?) 5)
			(if (not local0)
				(= local0 1)
				(ShakeScreen 1 1)
				(proc255_0 390 0)
				(gEgo setMotion: 0)
			)
		else
			(= local0 0)
		)
		(if (& (gEgo onControl:) $0002) (global2 newRoom: 360))
	)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(gTheMusic stop:)
				(= cycles 2)
				(= seconds 3)
			)
			(2 (gTheMusic stop:))
			(3
				(gTheMusic stop:)
				(= global101 (gGame setSpeed: 6))
				(proc255_0 390 10)
				(gTheMusic number: 390 loop: -1 play: self)
				(aSpeakerLeft init:)
				(aSpeakerRight init:)
				(aBambi cycleSpeed: 1 setCycle: Fwd)
				(= cycles 30)
			)
			(4
				(aBambi setLoop: 0)
				(= cycles 30)
			)
			(5
				(aBambi setLoop: 1)
				(= cycles 30)
			)
			(6
				(aBambi setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(aBambi setLoop: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(8
				(aBambi setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(9
				(aBambi setLoop: 4 setCycle: Fwd)
				(= cycles 30)
			)
			(10
				(Format @local1 390 11)
				(localproc_0040)
				(aBambi view: 392 setLoop: 0 cycleSpeed: 0)
				(= cycles 30)
			)
			(11
				(Format @local1 390 12)
				(localproc_001a)
				(aBambi setLoop: 1)
				(= cycles 30)
			)
			(12
				(Format @local1 390 13)
				(localproc_0040)
				(= cycles 30)
			)
			(13
				(aMike setCycle: End)
				(= cycles 30)
			)
			(14
				(aMike stopUpd:)
				(aBambi setLoop: 2 setCel: 0 setCycle: End self)
			)
			(15
				(aBambi setLoop: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(16
				(Format @local1 390 14)
				(localproc_0040)
				(aBambi setLoop: 4)
				(= cycles 30)
			)
			(17
				(aBambi setLoop: 5 setCel: 0 setCycle: End self)
			)
			(18
				(Format @local1 390 15)
				(localproc_001a)
				(aBambi setLoop: 6 setCycle: Fwd)
				(= cycles 30)
			)
			(19
				(aMonitorLeft dispose:)
				(aMonitorRight dispose:)
				(aLens init: setCycle: End self)
			)
			(20
				(aLens stopUpd:)
				(= seconds 5)
			)
			(21
				(= seconds 0)
				(Format @local1 390 16)
				(localproc_001a)
				(gTheMusic fade:)
				(aBambi
					view: 393
					setPri: -1
					setLoop: 0
					posn: 157 155
					setCycle: Walk
					setMotion: MoveTo 180 154 self
				)
			)
			(22
				(aBambi setMotion: MoveTo 200 134 self)
			)
			(23
				(gEgo
					setCycle: Walk
					setLoop: -1
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 180 154 self
				)
				(aBambi setScript: BambiScript)
				(BambiScript changeState: 6)
				(gGame setSpeed: global101)
			)
			(24
				(gEgo setMotion: MoveTo 200 134 self)
			)
			(25
				(gEgo setMotion: MoveTo 333 134)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'nightstand,get,jump,climb<on/backstage') (proc255_0 390 1))
			((Said 'get') (proc255_0 390 2))
			((Said 'drag<on/camera') (proc255_0 390 3))
			((Said 'make/tape') (proc255_0 390 4))
			(
				(or
					(Said '/class,(work<out),aerobic')
					(Said '//class,(work<out),aerobic')
					(Said 'class,dance,naked,naked,(work<out),class')
				)
				(if global118 (proc255_0 390 5) else (proc255_0 390 6))
			)
			((Said 'look>')
				(cond 
					(
					(Said '/camera,equipment,camera,tape,microphone') (proc255_0 390 7))
					((Said '/burn') (proc255_0 390 8))
					((Said '[/area]')
						(proc255_4
							390
							9
							(cond 
								((gCast contains: aBambi)
									{Una hermosa mujer rubia est* en el escenario con una expresi>n de perplejidad en el rostro.}
								)
								((proc0_22 53) {Parece que alguien estuvo aqu| recientemente haciendo un v|deo.})
								(else
									{Parece que el equipo ha sufrido alg{n tipo de aver|a.}
								)
							)
						)
					)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(proc0_26 aBambi (pEvent x?) (pEvent y?))
						(gCast contains: aBambi)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((not (& (gEgo onControl:) $0008)) (proc255_0 390 17))
								((proc0_22 8) (proc255_0 390 18))
								((proc0_22 10) (proc255_0 390 19))
								((proc0_22 62) (proc255_0 390 20))
								(else (BambiScript changeState: 4))
							)
						)
						(994
							(if (not (& (gEgo onControl:) $0008))
								(proc0_10)
							else
								(proc255_0 390 23)
							)
						)
						(995
							(proc255_0 390 21)
							(proc255_0 390 22 67 -1 144)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 232)
						(< (pEvent x?) 251)
						(> (pEvent y?) 70)
						(< (pEvent y?) 137)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 276 131)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 1)
						(< (pEvent x?) 232)
						(> (pEvent y?) 21)
						(< (pEvent y?) 136)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_4
								390
								9
								(cond 
									((gCast contains: aBambi)
										{Una hermosa mujer rubia est* en el escenario con una expresi>n de perplejidad en el rostro.}
									)
									((proc0_22 53) {Parece que alguien estuvo aqu| recientemente haciendo un v|deo.})
									(else
										{^Parece que el equipo ha sufrido alg{n tipo de aver|a!}
									)
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aBambi of Act
	(properties
		y 155
		x 160
		view 391
	)
	
	(method (init)
		(super init:)
		(self
			illegalBits: 0
			ignoreHorizon:
			ignoreActors:
			setPri: 15
			setScript: BambiScript
		)
	)
)

(instance BambiScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(aBambi
					setCycle: Fwd
					setLoop:
					(switch (Random 0 2)
						(0 0)
						(1 1)
						(else  4)
					)
				)
				(= seconds (Random 5 11))
			)
			(2
				(aBambi setLoop: 1 setCel: 0)
				(= seconds (Random 2 4))
				(= state 0)
			)
			(3)
			(4
				(aBambi setLoop: 1 setCel: 0)
				(if (proc0_22 71)
					(proc255_0 390 24)
				else
					(proc255_4 390 25 global171)
				)
				(= seconds 3)
			)
			(5
				(if (proc0_22 71)
					(proc255_0 390 26)
				else
					(proc0_19 71)
					(if global118
						(proc255_0 390 27)
					else
						(proc255_0 390 28)
					)
				)
				(= gGNumber_2 14)
				(global2 newRoom: 395)
			)
			(6
				(aBambi setMotion: MoveTo 333 134)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'look/babe')
				(cond 
					((not (& (gEgo onControl:) $0008)) (proc255_0 390 17))
					((proc0_22 8) (proc255_0 390 18))
					((proc0_22 10) (proc255_0 390 19))
					((proc0_22 62) (proc255_0 390 20))
					(else (self changeState: 4))
				)
			)
			((Said '/boob,body') (proc255_0 390 21) (proc255_0 390 22 67 -1 144))
			((Said '/babe')
				(if (not (& (gEgo onControl:) $0008))
					(proc0_10)
				else
					(proc255_0 390 23)
				)
			)
		)
	)
)

(instance aSpeakerLeft of Prop
	(properties
		y 154
		x 36
		view 390
		loop 2
		cel 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd)
	)
)

(instance aSpeakerRight of Prop
	(properties
		y 153
		x 294
		view 390
		loop 3
		cel 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd)
	)
)

(instance aLens of Prop
	(properties
		y 73
		x 60
		view 390
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 9 ignoreActors:)
	)
)

(instance aMike of Prop
	(properties
		y 61
		x 168
		view 390
		loop 1
		cycleSpeed 2
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 ignoreActors:)
	)
)

(instance aMonitorLeft of Prop
	(properties
		y 121
		x 93
		view 396
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors:)
	)
	
	(method (doit)
		(self
			view: (+ 5 (aBambi view?))
			loop: (aBambi loop?)
			cel: (aBambi cel?)
		)
		(super doit:)
	)
)

(instance aMonitorRight of Prop
	(properties
		y 121
		x 229
		view 396
	)
	
	(method (init)
		(super init:)
		(self setPri: 11 setCycle: Fwd ignoreActors:)
	)
	
	(method (doit)
		(self
			view: (+ 5 (aBambi view?))
			loop: (aBambi loop?)
			cel: (aBambi cel?)
		)
		(super doit:)
	)
)
