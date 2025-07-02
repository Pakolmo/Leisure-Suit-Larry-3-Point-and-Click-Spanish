;;; Sierra Script 1.0 - (do not remove this comment)
(script# 375)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm375 0
)

(instance rm375 of Rm
	(properties
		picture 375
		horizon 1
		south 370
	)
	
	(method (init)
		(if (gEgo has: 5) (Load rsVIEW 5))
		(aWater1 init:)
		(aWater2 init:)
		(aWater3 init:)
		(aWater4 init:)
		(aDrain init:)
		(if (proc0_22 49)
			(self picture: 376)
			(Load rsPIC 375)
			(Load rsVIEW 376)
			(gTheSoundFX number: 375 loop: global72 play:)
		else
			(self picture: 375)
			(Load rsPIC 376)
			(Load rsVIEW 377)
			(Load rsSOUND 375)
			(aWater1 hide:)
			(aWater2 hide:)
			(aWater3 hide:)
			(aWater4 hide:)
			(aDrain hide:)
		)
		(super init:)
		(self setScript: RoomScript)
		(proc0_1)
		(gEgo
			view: (cond 
				((proc0_22 49) 377)
				((>= global88 3) 376)
				(else 378)
			)
			posn: 53 176
			setPri: 11
			setStep: 5 5
			init:
		)
		(User canInput: 0 mapKeyToDir: 0)
	)
	
	(method (newRoom newRoomNumber)
		(gTheSoundFX fade:)
		(if (proc0_23 8 375) (gEgo get: 8) (proc255_0 375 0))
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (& (gEgo onControl:) $0004) (proc0_22 49))
			(proc0_19 50)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'shampoo') (proc255_0 375 1))
			((or (Said 'caress/self') (Said 'jack')) (proc0_6) (proc255_0 375 2 67 -1 144))
			(
			(Said 'cease,(drag<off)/bath,faucet,channel,handle,water')
				(cond 
					((not (proc0_22 49)) (proc0_7))
					((not (& (gEgo onControl:) $0002)) (proc255_0 375 3))
					(else
						(proc0_6)
						(gEgo view: (if (>= global88 3) 376 else 378))
						(proc0_20 49)
						(global2 drawPic: 375 8)
						(aWater1 hide:)
						(aWater2 hide:)
						(aWater3 hide:)
						(aWater4 hide:)
						(aDrain hide:)
						(gTheSoundFX stop:)
					)
				)
			)
			(
				(or
					(Said 'bath,bath')
					(Said 'get/bath')
					(Said 'use,(drag<on)/bath,faucet,channel,handle,water')
				)
				(cond 
					((proc0_22 49) (proc0_7))
					((not (& (gEgo onControl:) $0002)) (proc255_0 375 3))
					(else
						(proc0_6)
						(gEgo view: 377)
						(proc0_19 49)
						(global2 drawPic: 376 8)
						(if (> global87 16)
							(aWater1 show:)
							(aWater2 show:)
							(aWater3 show:)
							(aWater4 show:)
						)
						(aDrain show:)
						(gTheSoundFX number: 375 loop: global72 play:)
					)
				)
			)
			((Said 'rinse')
				(cond 
					((not (proc0_22 49)) (proc255_0 375 4))
					((not (& (gEgo onControl:) $0004)) (proc255_0 375 5))
					(else (proc0_6) (proc255_0 375 6))
				)
			)
			((or (Said 'clean') (Said 'clean,use/soap'))
				(cond 
					((not (proc0_22 49)) (proc255_0 375 4))
					((not (& (gEgo onControl:) $0004)) (proc255_0 375 5))
					((not (gEgo has: 5)) (proc255_0 375 7) (proc255_0 375 8 67 -1 144))
					(else
						(proc0_6)
						(proc0_20 8)
						(proc0_20 10)
						(gGame changeScore: 60)
						(gEgo put: 5 -1)
						(proc255_0 375 9 82 5 0 0)
						(proc255_0 375 10)
						(if (>= global88 3) (proc255_0 375 11))
						(proc255_0 375 12)
					)
				)
			)
			((and (not (gEgo has: 5)) (Said 'get/soap')) (proc255_0 375 13) (proc255_0 375 14 67 -1 144))
			((Said 'look>')
				(cond 
					((Said '/faucet,handle,channel')
						(if (proc0_22 49)
							(proc255_0 375 15)
						else
							(proc255_0 375 16)
						)
					)
					((Said '/drain')
						(if (proc0_22 49)
							(proc255_4 375 17 (if (Random 0 1) {counter-} else {}))
						else
							(proc255_0 375 18)
						)
					)
					((Said '[/carpet,bath,area]') (proc255_0 375 19))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 42)
						(< (pEvent x?) 286)
						(> (pEvent y?) 21)
						(< (pEvent y?) 134)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 375 19))
						(5
							(cond 
								((not (proc0_22 49)) (proc255_0 375 4))
								((not (& (gEgo onControl:) $0004)) (proc255_0 375 5))
								((not (gEgo has: 5)) (proc255_0 375 7) (proc255_0 375 8 67 -1 144))
								(else
									(proc0_6)
									(proc0_20 8)
									(proc0_20 10)
									(gGame changeScore: 60)
									(gEgo put: 5 -1)
									(= gGCursorNumber 900)
									(gGame setCursor: 998 (HaveMouse))
									(proc255_0 375 9 82 5 0 0)
									(proc255_0 375 10)
									(if (>= global88 3) (proc255_0 375 11))
									(proc255_0 375 12)
								)
							)
						)
						(995
							(cond 
								((proc0_22 49)
									(cond 
										((not (proc0_22 49)))
										((not (& (gEgo onControl:) $0002)) (proc255_0 375 3))
										(else
											(proc0_6)
											(gEgo view: (if (>= global88 3) 376 else 378))
											(proc0_20 49)
											(global2 drawPic: 375 8)
											(aWater1 hide:)
											(aWater2 hide:)
											(aWater3 hide:)
											(aWater4 hide:)
											(aDrain hide:)
											(gTheSoundFX stop:)
										)
									)
								)
								((not (& (gEgo onControl:) $0002)) (proc255_0 375 3))
								(else
									(proc0_6)
									(gEgo view: 377)
									(proc0_19 49)
									(global2 drawPic: 376 8)
									(if (> global87 16)
										(aWater1 show:)
										(aWater2 show:)
										(aWater3 show:)
										(aWater4 show:)
									)
									(aDrain show:)
									(gTheSoundFX number: 375 loop: global72 play:)
								)
							)
						)
						(994
							(cond 
								((not (proc0_22 49)) (proc255_0 375 4))
								((not (& (gEgo onControl:) $0004)) (proc255_0 375 5))
								(else (proc0_6) (proc255_0 375 6))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 30)
						(< (pEvent x?) 81)
						(> (pEvent y?) 157)
						(< (pEvent y?) 187)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 46 192)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aWater1 of Prop
	(properties
		y 91
		x 148
		view 375
		loop 1
		cel 1
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aWater2 of Prop
	(properties
		y 61
		x 178
		view 375
		loop 2
		cel 2
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aWater3 of Prop
	(properties
		y 92
		x 170
		view 375
		loop 1
		cel 3
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aWater4 of Prop
	(properties
		y 84
		x 128
		view 375
		loop 2
		cel 4
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aDrain of Prop
	(properties
		y 91
		x 148
		view 375
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd ignoreActors:)
	)
)
