;;; Sierra Script 1.0 - (do not remove this comment)
(script# 550)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm550 0
)

(local
	local0
	[local1 55]
	[local56 22]
	local78
)
(instance rm550 of Rm
	(properties
		picture 550
		horizon 50
		south 540
	)
	
	(method (init)
		(Load rsVIEW 551)
		(Load rsVIEW 552)
		(Load rsVIEW 553)
		(Load rsSOUND 6)
		(super init:)
		(User canInput: 0 canControl: 0 mapKeyToDir: 0)
		(aLog setCycle: Fwd init:)
		(self setScript: RoomScript)
		(if global64
			(= global108 1)
			(= global66 803)
			((Inv at: 17) view: 31)
			(= gGNumber_2 0)
		)
		(proc0_1)
		(gEgo posn: 159 188 loop: 3 init: viewer: PattiViewer)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_6)
				(gGame changeScore: 10)
				(proc0_3)
				(= gGNumber_2 551)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (+ (aLog x?) 20) (+ (aLog y?) -14) self
				)
			)
			(2
				(aLog hide:)
				(gEgo
					cycleSpeed: 1
					moveSpeed: 1
					viewer: 0
					posn: (aLog x?) (aLog y?)
					view: 553
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 170 131 self
				)
			)
			(3
				(aLog posn: 170 131 show:)
				(gEgo
					viewer: PattiViewer
					posn: (+ (aLog x?) 20) (+ (aLog y?) -14)
				)
				(proc0_1 2 551)
				(= gGNumber_2 0)
			)
			(4
				(proc0_6)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (+ (aLog x?) 20) (+ (aLog y?) -14) self
				)
			)
			(5
				(aLog hide:)
				(gEgo
					viewer: 0
					cycleSpeed: 1
					posn: (aLog x?) (aLog y?)
					view: 553
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setLoop: 2 setCycle: Fwd)
				(= gGNumber_2 550)
				(if (!= (aLog x?) 77)
					(self changeState: 10)
				else
					(= seconds 7)
				)
				(proc255_0 550 20)
				(if (>= global88 3) (proc255_0 550 21 67 -1 144))
			)
			(7
				(proc255_0 550 22)
				(User canInput: 1)
			)
			(8
				(proc0_6)
				(proc0_3)
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(9
				(= gGNumber_2 0)
				(aLog show:)
				(proc0_1 2 551)
				(gEgo
					viewer: PattiViewer
					posn: (+ (aLog x?) 20) (+ (aLog y?) -14)
				)
			)
			(10
				(gGame changeScore: 20)
				(gEgo
					cycleSpeed: 0
					setStep: 2 1
					setMotion: MoveTo 278 106 self
				)
				(= cycles 11)
			)
			(11
				(proc255_0 550 23)
				(proc255_0 550 24)
			)
			(12
				(gEgo setLoop: 3 setMotion: MoveTo 348 73 self)
			)
			(13
				(proc255_0 550 25)
				(global2 newRoom: 560)
			)
			(14
				(proc0_3)
				(= gGNumber_2 1003)
				(proc255_0 (Format @local1 550 26 global170) 67 -1 10 88)
				(= local0 0)
				(gEgo
					viewer: drowningViewer
					illegalBits: 0
					ignoreActors:
					view: 812
					setLoop: local0
					setCycle: Fwd
					setMotion: MoveTo (if (> (gEgo x?) 278) (gEgo x?) else 278) 106 self
				)
				(gTheSoundFX number: 6 loop: -1 play:)
			)
			(15
				(proc0_5)
				(= local0 2)
				(gEgo setMotion: MoveTo 348 73 self)
			)
			(16
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 816
					register: (Format @local1 550 27)
					next: (Format @local56 550 28)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'bang,board,(climb,lie,get<on)/log')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (< (gEgo distanceTo: aLog) 25)) (proc0_10))
					(else (self changeState: 4))
				)
			)
			(
				(Said
					'nightstand,exit,(get<off),(climb,get<off,up),(get<up),(nightstand<up)'
				)
				(if (!= gGNumber_2 550)
					(proc255_0 550 0)
				else
					(self changeState: 8)
				)
			)
			((Said 'weave') (proc255_0 550 1))
			((Said '/island') (proc255_0 550 2) (proc255_0 550 3 67 -1 144))
			((Said 'attack,attack,grasp,grab/log')
				(cond 
					((not (< (gEgo distanceTo: aLog) 25)) (proc0_10))
					((== gGNumber_2 550) (proc255_0 550 4))
					(else (proc255_0 550 5))
				)
			)
			((Said 'drag,drag,use/log')
				(cond 
					((not (< (gEgo distanceTo: aLog) 25)) (proc0_10))
					((== gGNumber_2 550) (proc255_0 550 6))
					((!= (aLog x?) 77) (proc255_0 550 7))
					(else (self changeState: 1))
				)
			)
			((Said 'drink') (proc255_0 550 8))
			(
				(or
					(Said 'board,exit,exit,(get<in)/water')
					(Said 'swim,wade')
				)
				(proc255_0 550 9)
			)
			((Said 'get>')
				(cond 
					((Said '/log') (proc255_0 550 10))
					((Said '/palm') (proc255_0 550 11))
					((Said '/bush') (proc255_0 550 12))
				)
			)
			((Said 'look<in/bush') (proc255_0 550 13))
			((Said 'look>')
				(cond 
					((Said '/log')
						(cond 
							((!= (aLog x?) 77) (proc255_0 550 14))
							((== (gEgo view?) global66) (proc255_0 550 15) (proc255_0 550 16 67 -1 144))
							(else (proc255_0 550 13))
						)
					)
					((Said '/bush') (proc255_0 550 17))
					((Said '/palm') (proc255_0 550 18))
					((Said '[/area,water,creek]') (proc255_0 550 19))
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
						(== gGNumber_2 550)
					)
					(pEvent claimed: 1)
					(if (== gCursorNumber 992)
						(cond 
							((not (< (gEgo distanceTo: aLog) 25)) (proc0_10))
							((!= (aLog x?) 77) (proc255_0 550 7))
							((== gGNumber_2 0) (proc255_0 550 6))
							(else (self changeState: 1))
						)
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 319)
						(> (pEvent y?) 21)
						(< (pEvent y?) 108)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 550 19))
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aLog (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((!= (aLog x?) 77) (proc255_0 550 14))
								((== (gEgo view?) global66) (proc255_0 550 15) (proc255_0 550 16 67 -1 144))
								(else (proc255_0 550 13))
							)
						)
						(995
							(= local78
								(proc255_0
									{&Qu+ quieres hacer con el tronco?}
									81
									{Moverlo}
									1
									81
									{Subirse}
									2
								)
							)
							(switch local78
								(1
									(cond 
										((not (< (gEgo distanceTo: aLog) 25)) (proc0_10))
										((== gGNumber_2 550) (proc255_0 550 6))
										((!= (aLog x?) 77) (proc255_0 550 7))
										(else (self changeState: 1))
									)
								)
								(2
									(cond 
										((!= gGNumber_2 0)
											(proc0_9)
											(if (!= gGNumber_2 550)
												(proc255_0 550 0)
											else
												(self changeState: 8)
											)
										)
										((not (< (gEgo distanceTo: aLog) 25)) (proc0_10))
										(else
											(self changeState: 4)
											(User canInput: 0 canControl: 0 mapKeyToDir: 0)
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
	)
)

(instance aLog of Prop
	(properties
		y 155
		x 77
		yStep 12
		view 550
		cycleSpeed 2
	)
)

(instance PattiViewer of Code
	(properties)
	
	(method (doit)
		(gEgo brBottom: (+ (gEgo y?) 1))
		(gEgo brTop: (- (gEgo brBottom?) (gEgo yStep?)))
		(gEgo brLeft: (- (gEgo x?) 8))
		(gEgo brRight: (+ (gEgo x?) 8))
		(cond 
			((& (gEgo onControl: 1) $0010) (RoomScript changeState: 14))
			((& (gEgo onControl:) $0004) (gEgo view: global66 setCycle: Walk))
			((& (gEgo onControl: 1) $0002) (gEgo view: 552 setCycle: Walk))
			((& (gEgo onControl: 1) $0008) ((Inv at: 17) view: 32) (gEgo view: 551 setCycle: Fwd))
		)
	)
)

(instance drowningViewer of Code
	(properties)
	
	(method (doit)
		(if (Random 0 5)
			(gEgo setLoop: (+ local0 (Random 0 1)))
		)
	)
)
