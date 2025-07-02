;;; Sierra Script 1.0 - (do not remove this comment)
(script# 560)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use DPath)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm560 0
)

(local
	local0
	local1
	local2
	local3
	local4
	gEgoX
	[local6 2]
	local8
	[local9 40]
	[local49 22]
)
(instance rm560 of Rm
	(properties
		picture 560
		horizon -10
	)
	
	(method (init)
		(Load rsSOUND 4)
		(Load rsSOUND 561)
		(Load rsSCRIPT 964)
		(= local3 222)
		(= local1 global15)
		(super init:)
		(gAddToPics add: atpHorizon doit:)
		(aDot init:)
		(aRightBank init:)
		(aLeftBank init:)
		(aObstacle init:)
		(self setScript: RoomScript)
		(proc0_1)
		(gEgo
			view: 561
			posn: 222 113
			setPri: 6
			setStep: 3 1
			setCycle: Fwd
			init:
		)
		(proc0_3)
		(User canInput: 0 canControl: 1 mapKeyToDir: 0)
		(gTheMusic number: 560 loop: -1 priority: 9999 play:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== state 2) (< (aObstacle distanceTo: gEgo) 9))
			(self changeState: 6)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(aObstacle hide:)
				(if (== (DotScript state?) 5)
					(self changeState: 4)
				else
					(= cycles (Random 5 10))
				)
			)
			(1
				(if (not (Random 0 2))
					(= local3 (Random 200 235))
					(aLeftBank setMotion: MoveTo local3 92)
					(aRightBank setMotion: MoveTo local3 92 self)
				else
					(self cue:)
				)
				(if (and (not (Random 0 2)) (< DotScript 3))
					(= state -1)
				)
			)
			(2
				(if (> (= gEgoX (Random 200 400)) 240)
					(= gEgoX (gEgo x?))
				)
				(cond 
					((< gEgoX (- local3 5)) (- gEgoX 5))
					((> gEgoX (+ local3 5)) (+ gEgoX 5))
				)
				(aObstacle
					posn: local3 89
					setLoop: (Random 0 local8)
					cel: local8
					setCycle: End
					show:
					setMotion: MoveTo gEgoX (+ (gEgo y?) 5) self
				)
				(if (== (aObstacle loop?) 3)
					(-- local8)
					(proc255_0 560 1 67 -1 10)
				)
			)
			(3
				(if (== (aObstacle loop?) 3)
					(proc255_0 560 2 67 -1 10)
				)
				(gGame changeScore: local8)
				(self changeState: 0)
			)
			(4
				(proc255_0 560 3 67 -1 10)
				(gGame changeScore: (- 150 (- global15 local1)))
				(gGame changeScore: (- 150 (- global15 local1)))
				(= seconds 3)
			)
			(5
				(proc255_0 560 4 67 -1 10)
				(DisposeScript 964)
				(gTheMusic priority: 0)
				(global2 newRoom: 580)
			)
			(6
				(= seconds (= cycles 0))
				(proc0_3)
				(aLeftBank setCel: 0)
				(aRightBank setCel: 0)
				(aDot setScript: 0 setMotion: 0 setCel: 0)
				(aObstacle hide:)
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
			)
			(7
				(gTheMusic stop:)
				(proc255_0 560 5 67 -1 10)
				(gTheSoundFX number: 4 loop: 1 play:)
				(aLog init:)
				(gEgo
					cycleSpeed: 0
					illegalBits: 0
					ignoreActors:
					setStep: 3 3
					setLoop: 5
					cel: 0
					setCycle: End self
					setMotion: MoveTo (aLeftBank x?) 100 self
				)
			)
			(8)
			(9
				(gTheSoundFX number: 561 loop: 1 play:)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 563
					register: (Format @local9 560 6)
					next: (Format @local49 560 7)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent claimed?) 0)
				(== (pEvent message?) KEY_F8)
				(< state 4)
			)
			(proc255_0 560 0)
			(= global15 local1)
			(proc0_19 77)
			(global2 newRoom: 580)
			(return)
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(> (pEvent y?) 20)
			)
			(pEvent claimed: 1)
			(if (not (& (pEvent modifiers?) emSHIFT))
				(gEgo setMotion: MoveTo 175 (gEgo y?))
			else
				(gEgo setMotion: MoveTo 265 (gEgo y?))
			)
		)
	)
)

(instance DotScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 2 2)
		(switch (= state newState)
			(0 (= seconds 1))
			(1
				(= local8 0)
				(aObstacle setStep: 2 2 cycleSpeed: 1)
				(aDot
					setMotion:
						DPath
						209
						179
						192
						183
						176
						186
						151
						187
						127
						186
						116
						182
						108
						182
						101
						179
						self
				)
			)
			(2
				(= local8 1)
				(aObstacle setStep: 3 3 cycleSpeed: 0)
				(aDot
					setMotion:
						DPath
						93
						178
						78
						173
						66
						164
						55
						150
						51
						140
						41
						133
						36
						126
						36
						115
						35
						109
						29
						104
						31
						96
						35
						85
						38
						78
						self
				)
			)
			(3
				(= local8 3)
				(aObstacle setStep: 4 4)
				(aDot
					setMotion: DPath 35 73 39 65 45 59 48 52 56 44 67 34 78 22 self
				)
			)
			(4
				(aDot setMotion: DPath 86 15 100 9 109 4 112 -3 self)
			)
		)
	)
)

(instance aDot of Act
	(properties
		y 188
		x 258
		view 560
		cycleSpeed 1
		moveSpeed 1
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			setScript: DotScript
			setCycle: Fwd
			setLoop: 3
			setStep: 1 1
			setPri: 15
			illegalBits: 0
			ignoreActors:
		)
	)
)

(instance atpHorizon of PV
	(properties
		y 91
		x 223
		view 560
		loop 1
		signal $4000
	)
)

(instance aLeftBank of Act
	(properties
		y 92
		x 222
		view 560
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCycle: Fwd
			setStep: 2 2
			illegalBits: 0
			ignoreActors:
		)
	)
)

(instance aRightBank of Act
	(properties
		y 92
		x 222
		view 560
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 2
			setCycle: Fwd
			setStep: 2 2
			illegalBits: 0
			ignoreActors:
		)
	)
)

(instance aObstacle of Act
	(properties
		y 87
		x 222
		view 562
	)
	
	(method (init)
		(super init:)
		(self setPri: 5 illegalBits: 0 ignoreActors:)
	)
)

(instance aLog of View
	(properties
		view 561
		loop 6
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 5 posn: (gEgo x?) (gEgo y?))
	)
)
