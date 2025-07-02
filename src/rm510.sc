;;; Sierra Script 1.0 - (do not remove this comment)
(script# 510)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm510 0
)

(local
	local0
)
(instance rm510 of Rm
	(properties
		picture 510
		horizon 65
		north 520
		south 500
	)
	
	(method (init)
		(proc0_19 37)
		(Load rsVIEW 511)
		(Load rsVIEW 812)
		(Load rsSOUND 6)
		(super init:)
		(self setScript: RoomScript)
		(aRock1 init:)
		(aRock2 init:)
		(aRock3 init:)
		(aRock4 init:)
		(aRock5 init:)
		(if (== gGNumber 520)
			(gEgo posn: 275 79 loop: 2)
		else
			(gEgo posn: 284 188)
		)
		(proc0_1)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			(
			(and (& (gEgo onControl: 1) $0200) (== gGNumber_2 0)) (self changeState: 2))
			((and (== gGNumber_2 12) (< 8 (++ local0)))
				(= local0 0)
				(gEgo
					setLoop: (+ (Random 0 1) (* 2 (< (gEgo y?) 87)))
				)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(2
				(= gGNumber_2 12)
				(proc0_3)
				(rm510 horizon: 1)
				(gEgo
					view: 812
					setLoop: 0
					setStep: 1 3
					setCycle: Fwd
					illegalBits: 0
					posn: (- (gEgo x?) 20) (gEgo y?)
					setMotion: MoveTo 160 104 self
				)
				(gTheMusic number: 6 loop: -1 play:)
			)
			(3
				(gEgo setMotion: MoveTo 179 87 self)
			)
			(4
				(gEgo setMotion: MoveTo 200 54 self)
			)
			(5 (global2 newRoom: 520))
			(6
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
			(7
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles
					(* 2 (gEgo cycleSpeed?) 4 (- (NumCels gEgo) 1))
				)
			)
			(8
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(9 (= seconds 2))
			(10
				(gGame changeScore: 42)
				(proc0_19 6)
				(proc0_1 1)
				(= gGNumber_2 0)
				(proc255_0 510 10)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'get/drink,water')
					(Said 'drink')
					(Said 'drink/water')
				)
				(cond 
					((proc0_22 6) (proc255_0 510 0))
					((not (& (gEgo onControl:) $0200)) (proc0_10))
					((!= gGNumber_2 0) (proc0_9))
					(else (self changeState: 6))
				)
			)
			((Said 'make/hemp') (proc255_0 510 1))
			(
			(or (Said 'make/boat') (Said 'climb,get,use/bamboo')) (proc255_0 510 2))
			((or (Said 'go<swim') (Said 'swim')) (proc255_0 510 3))
			((Said 'look>')
				(cond 
					((Said '/palm') (proc255_0 510 4))
					((Said '/boulder,boob') (proc255_0 510 5))
					((Said '/bamboo') (proc255_0 510 6))
					((Said '/cascade,creek') (proc255_0 510 7) (proc255_0 510 8 67 -1 144))
					((Said '[/area]') (proc255_0 510 9))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
					(> (pEvent x?) 66)
					(< (pEvent x?) 190)
					(> (pEvent y?) 114)
					(< (pEvent y?) 163)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(995
						(cond 
							((proc0_22 6) (proc255_0 510 0))
							((not (& (gEgo onControl:) $0200)) (proc0_10))
							((!= gGNumber_2 0) (proc0_9))
							(else (self changeState: 6))
						)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)

(instance aRock1 of Prop
	(properties
		y 177
		x 49
		view 520
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock2 of Prop
	(properties
		y 170
		x 169
		view 520
		loop 1
		cel 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock3 of Prop
	(properties
		y 189
		x 157
		view 520
		loop 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock4 of Prop
	(properties
		y 143
		x 52
		view 520
		loop 2
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock5 of Prop
	(properties
		y 104
		x 111
		view 520
		loop 2
		cel 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)
