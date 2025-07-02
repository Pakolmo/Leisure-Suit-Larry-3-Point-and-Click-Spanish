;;; Sierra Script 1.0 - (do not remove this comment)
(script# 470)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm470 0
)

(local
	theGGNumber
	local1
	local2
)
(instance rm470 of Rm
	(properties
		picture 470
	)
	
	(method (init)
		(if (gEgo has: 12) (Load rsVIEW 12))
		(Load rsVIEW (+ 715 (* 100 global108)))
		(Load rsSOUND 460)
		(super init:)
		(aBeamFront init:)
		(aBeamRear init:)
		(aDoor init:)
		(aFloor init:)
		(gAddToPics add: atpPanel doit:)
		(self setScript: RoomScript)
		(proc0_1 3)
		(gEgo posn: 161 137 init:)
		(User canInput: 0 mapKeyToDir: 0)
		(if (> gGNumber gNumber) (= local1 8))
		(aLight setPri: 4 setCel: local1 init: stopUpd:)
		(gTheMusic number: 32 loop: global72 play:)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 (= seconds 12))
			(1
				(proc255_0 470 18)
				(self changeState: 13)
			)
			(2
				(proc0_6)
				(proc0_3)
				(gEgo illegalBits: 0 setMotion: MoveTo 179 130 self)
			)
			(3
				(gEgo
					cycleSpeed: 1
					view: (+ 715 (* 100 global108))
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(4
				(if (not (proc0_22 63))
					(proc0_19 63)
					(gGame changeScore: 4)
					(proc255_0 470 19 82 12 0 0)
				)
				(gEgo setCycle: Beg self)
			)
			(5
				(proc0_1 3)
				(= cycles 10)
				(if (== theGGNumber 460) (= state 8))
			)
			(6
				(aLight setCel: (++ local1))
				(if (>= local1 9)
					(self changeState: 12)
				else
					(aBeamRear setMotion: MoveTo 159 260)
					(aBeamFront setMotion: MoveTo 160 260 self)
				)
			)
			(7
				(aBeamRear posn: 159 -16 setMotion: MoveTo 159 130)
				(aBeamFront posn: 160 -32 setMotion: MoveTo 160 80 self)
			)
			(8
				(aBeamRear posn: 159 48 setMotion: MoveTo 159 128)
				(aBeamFront setMotion: MoveTo 160 160 self)
				(= state 5)
			)
			(9
				(aLight setCel: (-- local1))
				(if (== local1 0)
					(self changeState: 12)
				else
					(aBeamRear setMotion: MoveTo 159 80)
					(aBeamFront setMotion: MoveTo 160 80 self)
				)
			)
			(10
				(aBeamRear posn: 159 104 setMotion: MoveTo 159 -32)
				(aBeamFront setMotion: MoveTo 160 -32 self)
			)
			(11
				(aBeamRear posn: 159 232 setMotion: MoveTo 159 128)
				(aBeamFront posn: 160 260 setMotion: MoveTo 160 160 self)
				(= state 8)
			)
			(12
				(aFloor
					setLoop: (if (== theGGNumber 460) 4 else 0)
					stopUpd:
				)
				(= seconds 3)
			)
			(13
				(proc0_3)
				(gTheSoundFX number: 460 loop: 1 play:)
				(aDoor setCycle: End self)
			)
			(14
				(aDoor stopUpd:)
				(gEgo illegalBits: 0 setMotion: MoveTo 160 128 self)
			)
			(15
				(gEgo setMotion: MoveTo 160 124 self)
			)
			(16
				(gTheMusic fade:)
				(if (not theGGNumber) (= theGGNumber gGNumber))
				(global2 newRoom: theGGNumber)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp [temp0 50])
		(if (pEvent claimed?) (return))
		(cond 
			(
			(or (Said 'use/key') (Said 'drag/button,carpet')) (proc255_0 470 0))
			(
				(or
					(Said '/penthouse,9,9')
					(Said '//penthouse,9,9')
					(Said 'go,drag/penthouse,9,9')
				)
				(cond 
					((not (gEgo has: 12))
						(proc255_0 470 1)
						(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
					)
					(theGGNumber (proc255_0 470 3))
					((> local1 7) (proc255_0 470 4))
					(else
						(if global108
							(= theGGNumber 484)
						else
							(= theGGNumber 480)
						)
						(self changeState: 2)
					)
				)
			)
			(
				(or
					(Said '/carpet,1,area')
					(Said '//carpet,1,(carpet<first),area')
					(Said 'go,drag/carpet,1,area')
				)
				(cond 
					((not (gEgo has: 12))
						(proc255_0 470 1)
						(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
					)
					(theGGNumber (proc255_0 470 3))
					((== local1 0) (proc255_0 470 4))
					(else (= theGGNumber 460) (self changeState: 2))
				)
			)
			((Said 'up,down,open,close/door,carpet,elevator') (proc255_0 470 5))
			((Said 'drag,go/button,door,carpet') (proc255_0 470 6))
			((Said 'hear') (if global108 (proc255_0 470 7) else (proc255_0 470 8)))
			((Said 'exit,go,exit,done,cease') (proc0_6) (proc255_0 470 9))
			((and (gEgo has: 9) (Said '/keycard')) (proc255_0 470 10))
			((Said 'pick,attack,break/bolt') (proc255_0 470 11))
			((Said 'look>')
				(cond 
					((Said '/burn') (proc255_4 470 12 (+ 1 (aLight cel?))))
					((Said '/handle,button') (proc255_0 470 13))
					((Said '/door')
						(proc255_4
							470
							14
							(if (aDoor cel?) {abierto} else {cerrado})
						)
					)
					((Said '/(hole<key),bolt') (proc255_0 470 15))
					((Said '[/area,elevator]') (proc255_0 470 16) (proc255_0 470 17 67 -1 144))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if (proc0_26 aDoor (pEvent x?) (pEvent y?))
					(switch gCursorNumber
						(998
							(pEvent claimed: 1)
							(proc255_4
								470
								14
								(if (aDoor cel?) {abierto} else {cerrado})
							)
						)
						(995
							(pEvent claimed: 1)
							(proc0_6)
							(proc255_0 470 9)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 atpPanel (pEvent x?) (pEvent y?))
					(switch gCursorNumber
						(998
							(pEvent claimed: 1)
							(proc255_0 470 13)
						)
						(30
							(pEvent claimed: 1)
							(= local2
								(proc255_0
									{&D>nde quieres ir?}
									81
									{Atico}
									1
									81
									{Abajo}
									2
								)
							)
							(switch local2
								(1
									(cond 
										((not (gEgo has: 12))
											(proc255_0 470 1)
											(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
										)
										(theGGNumber (proc255_0 470 3))
										((> local1 7) (proc255_0 470 4))
										(else
											(if global108
												(= theGGNumber 484)
											else
												(= theGGNumber 480)
											)
											(self changeState: 2)
										)
									)
								)
								(2
									(cond 
										((not (gEgo has: 12))
											(proc255_0 470 1)
											(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
										)
										(theGGNumber (proc255_0 470 3))
										((== local1 0) (proc255_0 470 4))
										(else (= theGGNumber 460) (self changeState: 2))
									)
								)
							)
						)
						(12
							(pEvent claimed: 1)
							(= local2
								(proc255_0
									{&D>nde quieres ir?}
									81
									{Atico}
									1
									81
									{Abajo}
									2
								)
							)
							(switch local2
								(1
									(cond 
										((not (gEgo has: 12))
											(proc255_0 470 1)
											(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
										)
										(theGGNumber (proc255_0 470 3))
										((> local1 7) (proc255_0 470 4))
										(else
											(if global108
												(= theGGNumber 484)
											else
												(= theGGNumber 480)
											)
											(self changeState: 2)
										)
									)
								)
								(2
									(cond 
										((not (gEgo has: 12))
											(proc255_0 470 1)
											(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
										)
										(theGGNumber (proc255_0 470 3))
										((== local1 0) (proc255_0 470 4))
										(else (= theGGNumber 460) (self changeState: 2))
									)
								)
							)
						)
						(995
							(pEvent claimed: 1)
							(= local2
								(proc255_0
									{&D>nde quieres ir?}
									81
									{Atico}
									1
									81
									{Abajo}
									2
								)
							)
							(switch local2
								(1
									(cond 
										((not (gEgo has: 12))
											(proc255_0 470 1)
											(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
										)
										(theGGNumber (proc255_0 470 3))
										((> local1 7) (proc255_0 470 4))
										(else
											(if global108
												(= theGGNumber 484)
											else
												(= theGGNumber 480)
											)
											(self changeState: 2)
										)
									)
								)
								(2
									(cond 
										((not (gEgo has: 12))
											(proc255_0 470 1)
											(proc255_0 (Format @temp0 470 2 global82) 67 -1 144)
										)
										(theGGNumber (proc255_0 470 3))
										((== local1 0) (proc255_0 470 4))
										(else (= theGGNumber 460) (self changeState: 2))
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

(instance atpPanel of PV
	(properties
		y 110
		x 184
		view 470
		loop 1
		priority 5
	)
)

(instance aLight of Prop
	(properties
		y 62
		x 160
		view 460
		loop 2
	)
)

(instance aBeamFront of Act
	(properties
		y 156
		x 160
		view 470
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setPri: 15
			setLoop: (if (> global87 16) 3 else 5)
			setStep: 0 8
		)
	)
)

(instance aBeamRear of Act
	(properties
		y 125
		x 160
		view 470
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setPri: 2
			setLoop: (if (> global87 39) 2 else 5)
			setStep: 0 8
		)
	)
)

(instance aDoor of Prop
	(properties
		y 125
		x 160
		view 460
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setCel: 0 species 6 stopUpd: ignoreActors:)
	)
)

(instance aFloor of Prop
	(properties
		y 125
		x 160
		view 470
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self
			setPri: 5
			setLoop: (if (== gGNumber 460) 4 else 0) species
			stopUpd:
		)
	)
)
