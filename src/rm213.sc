;;; Sierra Script 1.0 - (do not remove this comment)
(script# 213)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm213 0
)

(local
	local0
	local1
	local2
)
(instance rm213 of Rm
	(properties
		picture 213
		horizon 5
		east 210
	)
	
	(method (init)
		(super init:)
		(if (proc0_22 15) (= global98 2))
		(if global98 (aNewspaper init:))
		(aRiver init:)
		(aRiver2 init:)
		(aTv init:)
		(self setScript: RoomScript)
		(if (not (proc0_22 26))
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(gEgo posn: 314 163)
		(proc0_1)
		(gEgo init:)
		(gTheSoundFX number: 213 loop: -1 play:)
		(User canInput: 0 mapKeyToDir: 0)
	)
	
	(method (newRoom newRoomNumber)
		(gTheMusic fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= cycles (= seconds 0))
				(proc0_3)
				(cond 
					((> (gEgo y?) 171) (gEgo setMotion: MoveTo (gEgo x?) 171 self))
					((< (gEgo y?) 126) (gEgo setMotion: MoveTo (gEgo x?) 126 self))
					(else (self cue:))
				)
			)
			(2
				(cond 
					((> (gEgo x?) 171) (gEgo setMotion: MoveTo 171 (gEgo y?) self))
					((< (gEgo x?) 122) (gEgo setMotion: MoveTo 122 (gEgo y?) self))
					(else (self cue:))
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x?) 171 self)
			)
			(4
				(= cycles (= seconds 0))
				(gEgo view: 214 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(User canInput: 1)
				(= gGNumber_2 1004)
			)
			(6
				(gEgo setCel: 0 loop: 1)
				(= seconds (Random 1 4))
			)
			(7 (gEgo setCycle: End self))
			(8
				(gEgo setCycle: Beg self)
				(= state 5)
			)
			(9
				(proc0_3)
				(= cycles (= seconds 0))
				(if local1
					(proc255_0 213 30)
					(= local1 0)
					(aNewspaper posn: 198 190)
				)
				(gEgo view: 214 setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(10
				(proc0_1 3)
				(= gGNumber_2 0)
			)
			(11 (= seconds 0))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return (pEvent claimed?)))
		(return
			(cond 
				((Said 'drag<on/camera,backdrop')
					(cond 
						((not (gEgo inRect: 134 125 164 131)) (proc0_10))
						((< (aTv y?) 200) (proc0_7))
						(else (proc0_6) (aTv posn: 148 116))
					)
				)
				((Said 'drag<off/camera,backdrop')
					(cond 
						((not (gEgo inRect: 134 125 164 131)) (proc0_10))
						((> (aTv y?) 200) (proc0_7))
						(else (proc0_6) (aTv posn: 148 1116))
					)
				)
				((Said 'lie')
					(cond 
						(global108 (proc255_0 213 0))
						((== gGNumber_2 1004) (proc0_8))
						((!= gGNumber_2 0) (proc0_9))
						(else (proc0_6) (self changeState: 1))
					)
				)
				(
					(or
						(Said 'nightstand,(get<off),(get<up),(nightstand<up)')
						(Said 'exit/barstool')
					)
					(cond 
						((== gGNumber_2 0) (proc0_8))
						((!= gGNumber_2 1004) (proc0_9))
						(else (self changeState: 9))
					)
				)
				((Said 'swim') (proc255_0 213 1))
				((Said 'drag,alter/channel')
					(if (< (aTv y?) 200)
						(proc255_0 213 2)
					else
						(proc255_0 213 3)
					)
				)
				((Said 'drag<on/burn') (proc255_0 213 4))
				((Said 'drag<off/burn') (proc255_0 213 5))
				((Said 'caress,look<below,back,behind/buffet') (proc255_0 213 6) (proc255_0 213 7) (proc255_0 213 8))
				((Said 'look,caress<below/barstool') (proc255_0 213 9))
				(
					(or
						(Said '//camera,backdrop>')
						(Said '/camera,backdrop>')
					)
					(cond 
						((Said 'watch')
							(if (< (aTv y?) 200)
								(proc255_0 213 10)
							else
								(proc255_0 213 11)
							)
						)
						((Said 'look')
							(if (< (aTv y?) 200)
								(proc255_0 213 10)
							else
								(proc255_0 213 12)
							)
						)
						((Said 'adjust') (proc255_0 213 13))
						((Said 'get') (proc255_0 213 14))
						((Said 'caress,look<back,below,behind')
							(if (< (aTv y?) 200)
								(proc255_0 213 15)
								(proc255_0 213 16 67 -1 144)
								(gGame changeScore: -1)
							else
								(proc255_0 213 17)
							)
						)
						(else (proc255_0 213 18) (pEvent claimed: 1))
					)
				)
				((Said 'get/buffet') (proc255_4 213 19 global82))
				((Said 'get/burn') (proc255_0 213 20))
				((Said 'look/barstool')
					(if (== gGNumber_2 1004)
						(proc255_0 213 21)
					else
						(proc255_0 213 22)
					)
				)
				((Said 'look>')
					(cond 
						((Said '/burn') (proc255_4 213 23 global82))
						((Said '/buffet')
							(cond 
								(local1 (proc255_0 213 24))
								((gCast contains: aNewspaper) (proc255_0 213 25))
								(else (proc255_0 213 26))
							)
						)
						((Said '/creek,cascade,water') (proc255_0 213 27))
						((Said '/carpet') (proc255_0 213 28))
						((Said '[/area]') (proc255_0 213 29))
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
						)
						(if (== local1 1)
							(switch global98
								(2
									(proc255_0 213 32)
									(proc255_0 213 33 33 global26 30 1 67 -1 30 70 234)
								)
								(1
									(proc255_0 213 34)
									(proc255_0 213 35 33 global26 30 1 67 -1 30 70 234)
								)
								(3
									(proc255_0 213 36 33 global26 30 1 67 -1 30 70 234)
								)
								(else 
									(proc255_0 213 37)
									(proc255_0 213 38 67 -1 144)
								)
							)
						)
						(if (== gCursorNumber 992) (self changeState: 9))
					)
					(if
						(and
							(> (pEvent x?) 312)
							(> (pEvent y?) 122)
							(< (pEvent y?) 188)
							(== gCursorNumber 999)
						)
						(gEgo setMotion: MoveTo 321 158)
						(pEvent claimed: 1)
					)
					(if
						(and
							(> (pEvent x?) 1)
							(< (pEvent x?) 319)
							(> (pEvent y?) 21)
							(< (pEvent y?) 61)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998 (proc255_0 213 29))
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 132)
							(< (pEvent x?) 162)
							(> (pEvent y?) 100)
							(< (pEvent y?) 122)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(994
								(if (< (aTv y?) 200)
									(proc255_0 213 15)
									(proc255_0 213 16 67 -1 144)
									(gGame changeScore: -1)
								else
									(proc255_0 213 18)
								)
							)
							(998
								(if (< (aTv y?) 200)
									(proc255_0 213 10)
								else
									(proc255_0 213 11)
								)
							)
							(995
								(cond 
									((not (gEgo inRect: 134 125 164 131)) (proc0_10))
									((== local2 0) (proc0_6) (aTv posn: 148 116) (= local2 1))
									((== local2 1) (proc0_6) (aTv posn: 148 1116) (= local2 0))
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 1)
							(< (pEvent x?) 58)
							(> (pEvent y?) 61)
							(< (pEvent y?) 171)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998 (proc255_0 213 27))
							(995 (proc255_0 213 1))
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 97)
							(< (pEvent x?) 193)
							(> (pEvent y?) 62)
							(< (pEvent y?) 90)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(proc255_4 213 23 global82)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 108)
							(< (pEvent x?) 186)
							(> (pEvent y?) 154)
							(< (pEvent y?) 172)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(998
								(if (== gGNumber_2 1004)
									(proc255_0 213 21)
								else
									(proc255_0 213 22)
								)
							)
							(995
								(cond 
									(global108 (proc255_0 213 0))
									((== gGNumber_2 1004) (proc0_8))
									((!= gGNumber_2 0) (proc0_9))
									(else (proc0_6) (self changeState: 1))
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(and
							(> (pEvent x?) 190)
							(< (pEvent x?) 204)
							(> (pEvent y?) 164)
							(< (pEvent y?) 172)
							(gCast contains: aNewspaper)
						)
						(pEvent claimed: 1)
						(switch gCursorNumber
							(995
								(cond 
									(global108 (proc255_0 213 31))
									(local1 (proc0_11))
									((not (gEgo inRect: 170 161 221 187)) (proc0_10))
									((and (!= gGNumber_2 0) (!= gGNumber_2 1004)) (proc0_9))
									(global108
										(proc0_6)
										(aNewspaper posn: 198 1190)
										(= local1 1)
										(if (== gGNumber_2 1004)
											(RoomScript changeState: 5)
										else
											(RoomScript changeState: 1)
										)
									)
								)
							)
							(998
								(cond 
									(global108 (proc255_0 213 31))
									(local1 (proc0_11))
									((not (gEgo inRect: 170 161 221 187)) (proc0_10))
									((and (!= gGNumber_2 0) (!= gGNumber_2 1004)) (proc0_9))
									(else
										(proc0_6)
										(aNewspaper posn: 198 1190)
										(= local1 1)
										(if (== gGNumber_2 1004)
											(RoomScript changeState: 5)
										else
											(RoomScript changeState: 1)
										)
									)
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
				)
				(else 0)
			)
		)
	)
)

(instance aTv of Prop
	(properties
		y 1116
		x 148
		view 213
		loop 1
		priority 4
		cycleSpeed 2
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance aRiver of Prop
	(properties
		y 104
		x 31
		view 213
		loop 2
		cycleSpeed 2
	)
	
	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aRiver2 of Prop
	(properties
		y 141
		view 213
		loop 3
		cel 1
		cycleSpeed 2
	)
	
	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd)
	)
)

(instance aNewspaper of View
	(properties
		y 190
		x 198
		view 213
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setPri: 15
			z: (- (aNewspaper y?) 169)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(!= (pEvent type?) evSAID)
				(pEvent claimed?)
				(not (Said '/document>'))
			)
			(return)
		)
		(if (Said 'get')
			(cond 
				(global108 (proc255_0 213 31))
				(local1 (proc0_11))
				((not (gEgo inRect: 170 161 221 187)) (proc0_10))
				((and (!= gGNumber_2 0) (!= gGNumber_2 1004)) (proc0_9))
				(else
					(proc0_6)
					(aNewspaper posn: 198 1190)
					(= local1 1)
					(if (== gGNumber_2 1004)
						(RoomScript changeState: 5)
					else
						(RoomScript changeState: 1)
					)
				)
			)
		)
		(if (Said 'backdrop,backdrop,close')
			(if (not local1)
				(proc0_12)
			else
				(proc0_6)
				(= local1 0)
				(aNewspaper posn: 198 190)
				(gEgo view: 214 setLoop: 0 setCel: 255)
				(RoomScript cycles: 0 seconds: 0 changeState: 5)
			)
		)
		(if (Said 'look')
			(if (not local1)
				(proc0_12)
			else
				(switch global98
					(2
						(proc255_0 213 32)
						(proc255_0 213 33 33 global26 30 1 67 -1 30 70 234)
					)
					(1
						(proc255_0 213 34)
						(proc255_0 213 35 33 global26 30 1 67 -1 30 70 234)
					)
					(3
						(proc255_0 213 36 33 global26 30 1 67 -1 30 70 234)
					)
					(else 
						(proc255_0 213 37)
						(proc255_0 213 38 67 -1 144)
					)
				)
			)
		)
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 215
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 240
		view 215
		loop 1
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(proc0_19 26)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)
