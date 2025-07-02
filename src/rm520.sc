;;; Sierra Script 1.0 - (do not remove this comment)
(script# 520)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm520 0
)

(local
	local0
	[local1 50]
	[local51 22]
)
(instance rm520 of Rm
	(properties
		picture 520
		east 523
		south 510
	)
	
	(method (init)
		(Load rsVIEW 511)
		(Load rsVIEW 812)
		(Load rsVIEW 813)
		(Load rsVIEW 521)
		(Load rsSOUND 4)
		(Load rsSOUND 6)
		(if (gEgo has: 15) (Load rsVIEW 15))
		(super init:)
		(self setScript: RoomScript)
		(aRock1 init:)
		(aRock2 init:)
		(aRock3 init:)
		(aRock4 init:)
		(aRock5 init:)
		(cond 
			((== gGNumber_2 12)
				(gEgo posn: 69 188)
				(= gGNumber_2 1003)
				(RoomScript changeState: 1)
			)
			((== gGNumber 523) (proc0_1 1))
			(else (gEgo posn: 181 188) (proc0_1 3))
		)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			(
			(and (& (gEgo onControl: 1) $0200) (== gGNumber_2 0)) (self changeState: 1))
			((and (== gGNumber_2 1003) (< 8 (++ local0)))
				(= local0 0)
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
						register: (Format @local1 520 30)
						next: (Format @local51 520 31)
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
				(proc255_0 (Format @local1 520 33 global170) 67 -1 10 88)
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
		(if (pEvent claimed?) (return))
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
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 187)
						(< (pEvent x?) 240)
						(> (pEvent y?) 71)
						(< (pEvent y?) 94)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(15
							(cond 
								((not (gEgo has: 15)) (proc255_0 520 7))
								((not (proc0_22 72)) (proc255_0 520 8))
								((!= gGNumber_2 0) (proc0_9))
								((not (& (gEgo onControl:) $0010)) (proc255_0 520 11))
								(else
									(= gGCursorNumber 900)
									(gGame setCursor: 998 (HaveMouse))
									(self changeState: 18)
								)
							)
							(pEvent claimed: 1)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 1)
						(< (pEvent x?) 111)
						(> (pEvent y?) 124)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(995
							(cond 
								((proc0_22 6) (proc255_0 520 0))
								((!= gGNumber_2 0) (proc0_9))
								((not (& (gEgo onControl:) $0200)) (proc0_10))
								(else (self changeState: 7))
							)
						)
						(998
							(proc255_0 520 17)
							(proc255_0 520 18 67 -1 144)
							(pEvent claimed: 1)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 120)
						(< (pEvent x?) 319)
						(> (pEvent y?) 21)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 520 19))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 313)
						(< (pEvent x?) 319)
						(> (pEvent y?) 97)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 321 130)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 107)
						(< (pEvent x?) 319)
						(> (pEvent y?) 176)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 195 192)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aRock1 of Prop
	(properties
		y 160
		x -18
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
		y 187
		x 56
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
		y 179
		x 37
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
		y 118
		x -5
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
		y 176
		x 12
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
