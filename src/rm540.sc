;;; Sierra Script 1.0 - (do not remove this comment)
(script# 540)
(include sci.sh)
(use Main)
(use Class_255_0)
(use n958)
(use Wander)
(use Jump)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm540 0
	RoomScript 1
)

(local
	local0
	[local1 33]
	[local34 22]
)
(instance rm540 of Rm
	(properties
		picture 540
		horizon 78
		north 550
		south 530
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(if (== gGNumber 550)
			(gEgo posn: 233 80)
		else
			(gEgo posn: 233 188)
		)
		(if (not (proc0_22 68))
			(Load rsVIEW 541)
			(Load rsVIEW 542)
			(Load rsVIEW 543)
			(Load rsSCRIPT 991)
			(Load rsSCRIPT 970)
			(Load rsSOUND 540)
			(Load rsSOUND 541)
			(Load rsSOUND 12)
			(Load rsSOUND 561)
			(Load rsSOUND 530)
			(aPig init:)
			(aBra init:)
		)
		(= global66 803)
		((Inv at: 17) view: 31)
		(= gGNumber_2 0)
		(proc0_1 3)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(proc958_0 0 970)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== state 7)
				(== 541 (gEgo view?))
				(== 2 (gEgo loop?))
				(== 1 (gEgo cel?))
			)
			(gTheSoundFX number: 530 loop: 1 play:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(proc0_19 73)
				(if (not (proc0_22 75))
					(proc0_19 75)
					(gGame changeScore: 5)
				)
				(proc0_6)
				(gEgo
					view: 541
					setLoop: 0
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(proc255_0 540 25 67 -1 10)
				(proc0_1 3)
			)
			(3
				(proc0_3)
				(proc0_6)
				(proc0_20 73)
				(proc0_20 74)
				(gEgo
					view: 541
					setLoop: 0
					setCel: 255
					illegalBits: 0
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(4
				(proc255_0 540 26)
				(proc0_1 3)
			)
			(5
				(proc0_3)
				(proc0_19 74)
				(if (not (proc0_22 76))
					(proc0_19 76)
					(gGame changeScore: 45)
				)
				(proc0_6)
				(gEgo
					view: 541
					setLoop: 1
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(proc255_0 540 27)
				(proc0_1 3)
				(proc255_0 540 28 67 -1 144)
			)
			(7
				(proc0_3)
				(proc0_6)
				(proc0_20 73)
				(gTheMusic stop:)
				(= global101 (gGame setSpeed: 6))
				(= gGNumber_2 540)
				(gEgo
					view: 541
					setLoop: 2
					illegalBits: 0
					cel: 0
					setCycle: Fwd
				)
				(= cycles (* 5 (- (NumCels gEgo) 1)))
			)
			(8
				(proc0_1 3)
				(proc0_3)
				(aBra
					ignoreHorizon:
					posn: (+ (gEgo x?) 23) (- (gEgo y?) 43)
					setLoop: 3
					setCycle: Fwd
					setStep: 8 8
					setMotion: JumpTo (- (aPig x?) 2) (- (aPig y?) 13) self
				)
				(PigScript changeState: 9)
			)
			(9
				(PigScript cue:)
				(aBra dispose:)
				(if (proc0_22 74)
					(gEgo put: 16 -1 put: 19 -1)
					(self changeState: 11)
				else
					(= seconds 3)
				)
			)
			(10
				(proc255_0 540 29)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 543
					register: (Format @local1 540 30)
					next: (Format @local34 540 31)
				)
			)
			(11 (= cycles 0) (= seconds 3))
			(12
				(proc255_0 540 32 67 -1 10)
				(proc0_1 3)
				(= gGNumber_2 0)
				(proc255_0 540 33 67 -1 144)
				(gTheMusic number: 599 loop: global72 play:)
				(proc0_19 68)
				(gGame changeScore: 100)
				(gGame setSpeed: global101)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'use/bra,coconut') (proc255_0 540 0))
			((Said 'use/marker') (proc255_0 540 1))
			((and (gEgo has: 12) (Said '/key')) (proc255_0 540 2))
			((Said 'climb/palm') (proc255_0 540 3))
			((Said '(backdrop<on),wear/bra')
				(cond 
					((proc0_23 16 484) (proc255_0 540 4))
					((proc0_23 16 -1) (proc0_12))
					((!= gGNumber_2 0) (proc0_9))
					((not (proc0_22 73)) (proc255_0 540 5))
					((proc0_22 74) (proc255_0 540 6))
					(else (self changeState: 3))
				)
			)
			((Said 'drain,(off<get),(get<off)/bra')
				(cond 
					((proc0_23 16 484) (proc255_0 540 4))
					((proc0_23 16 -1) (proc0_12))
					((proc0_22 73) (proc255_0 540 7))
					((!= gGNumber_2 0) (proc0_9))
					(else (self changeState: 1))
				)
			)
			(
				(and
					(proc0_22 74)
					(Said 'drain,(out<get),(get<out)/coconut')
				)
				(proc0_20 74)
				(proc255_0 540 8)
			)
			((Said 'backdrop/coconut/bra')
				(cond 
					((not (gEgo has: 16)) (proc255_0 540 9))
					((not (gEgo has: 19))
						(proc255_0 540 10)
						(if (>= global88 3) (proc255_0 540 11 67 -1 144))
					)
					((!= gGNumber_2 0) (proc0_9))
					((not (proc0_22 73)) (proc255_0 540 12) (proc255_0 540 13 67 -1 144))
					((proc0_22 74) (proc255_0 540 14))
					(else (self changeState: 5))
				)
			)
			(
				(or
					(Said 'use/bra/throw')
					(Said 'throw/coconut/animal')
					(Said 'throw/bra')
				)
				(cond 
					((proc0_23 16 484) (proc255_0 540 4))
					((not (gEgo has: 16)) (proc0_12))
					((not (proc0_22 73)) (proc255_0 540 15))
					((!= gGNumber_2 0) (proc0_9))
					((!= (PigScript state?) 2) (proc255_0 540 16))
					(else (self changeState: 7))
				)
			)
			((Said 'throw/coconut')
				(if (gEgo has: 19)
					(proc255_0 540 17)
				else
					(proc255_0 540 10)
					(if (> global88 1) (proc255_0 540 18 67 -1 144))
				)
			)
			((Said 'throw>')
				(cond 
					((Said '[/!*]') (proc255_0 540 19))
					((Said '/*[/!*]') (proc255_0 540 20))
				)
			)
			((Said 'climb,crawl') (proc255_0 540 21))
			((Said 'look>')
				(cond 
					((Said '/creek') (proc255_0 540 22))
					((Said '[/area]') (proc255_0 540 23) (proc255_0 540 24 67 -1 144))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if (proc0_26 aPig (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(16
							(pEvent claimed: 1)
							(cond 
								((proc0_23 16 484) (proc255_0 540 4))
								((not (gEgo has: 16)) (proc0_12))
								((not (proc0_22 73)) (proc255_0 540 15))
								((!= gGNumber_2 0) (proc0_9))
								((!= (PigScript state?) 2) (proc255_0 540 16))
								(else (self changeState: 7))
							)
						)
						(998 (proc255_0 540 48))
						(997 (proc255_0 540 47))
						(995 (proc255_0 540 46))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 gEgo (pEvent x?) (pEvent y?))
						(== gCursorNumber 16)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(16
							(cond 
								((proc0_23 16 484) (proc255_0 540 4))
								((proc0_23 16 -1) (proc0_12))
								((proc0_22 73) (proc255_0 540 7))
								((!= gGNumber_2 0) (proc0_9))
								(else
									(= gGCursorNumber 900)
									(gGame setCursor: 998 (HaveMouse))
									(self changeState: 1)
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 153)
						(< (pEvent x?) 319)
						(> (pEvent y?) 53)
						(< (pEvent y?) 69)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998 (proc255_0 540 22))
						(16 (pEvent claimed: 1))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 225)
						(> (pEvent y?) 70)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 540 23)
							(proc255_0 540 24 67 -1 144)
						)
						(16 (pEvent claimed: 1))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aBra of Act
	(properties
		y 999
		x 999
		view 541
		illegalBits $0000
	)
)

(instance aPig of Act
	(properties
		y 111
		x 288
		view 540
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			setLoop: 0
			setPri: 1
			setCycle: Fwd
			setStep: 4 4
			setScript: PigScript
		)
	)
)

(instance PigScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			((== gGNumber_2 540))
			((and (< state 4) (& (gEgo onControl:) $0002)) (self changeState: 4))
			(
				(and
					(& (gEgo onControl: 1) $0010)
					(or (== state 1) (== state 2))
				)
				(self changeState: 3)
			)
			(
				(and
					(& (gEgo onControl: 1) $0004)
					(or (== state 0) (== state 3))
				)
				(self changeState: 1)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gTheMusic number: 540 loop: -1 play:)
				(aPig setMotion: MoveTo 216 97 self)
			)
			(2
				(if (not local0)
					(= local0 1)
					(proc255_0 540 34 67 10 5 70 290)
				)
				(aPig
					illegalBits: -3
					setMotion: Wander
					setPri: -1
					setStep: 2 2
				)
			)
			(3
				(gTheMusic fade:)
				(aPig
					illegalBits: 0
					setPri: 1
					setMotion: MoveTo 288 111 self
				)
				(= state -1)
			)
			(4
				(= gGNumber_2 1001)
				(proc0_3)
				(proc255_0 540 35 67 -1 10)
				(gTheSoundFX stop:)
				(gTheMusic number: 541 loop: 1 play:)
				(aPig
					illegalBits: 0
					ignoreActors:
					setPri: -1
					setLoop: 1
					setCel: 0
					setCycle: End
					setStep: 4 10
					setMotion:
						MoveTo
						(- (aPig x?) (/ (- (aPig x?) (gEgo x?)) 2))
						-10
						self
				)
			)
			(5
				(aPig
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 40) self
				)
			)
			(6
				(gTheMusic number: 12 loop: 1 play:)
				(gEgo view: 542 cel: 0 setCycle: End)
				(aPig setMotion: MoveTo (gEgo x?) (gEgo y?) self)
			)
			(7
				(gEgo stopUpd:)
				(aPig setLoop: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(if (>= global88 3)
					(proc255_0 540 36 67 -1 10)
					(proc255_0 540 37 67 -1 144)
				else
					(proc255_0 540 38 67 -1 10)
					(proc255_0 540 39 67 -1 10)
				)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 543
					register: (Format @local1 540 40)
					next: (Format @local34 540 41)
				)
			)
			(9
				(= seconds (= cycles 0))
				(aPig setMotion: 0)
			)
			(10
				(= seconds (= cycles 0))
				(gTheMusic stop:)
				(if (proc0_22 74)
					(gTheSoundFX number: 12 loop: 1 play:)
					(aPig
						illegalBits: 0
						setLoop: 3
						cel: 0
						setStep: 4 4
						setCycle: End
						setMotion: JumpTo 225 69 self
					)
				else
					(self changeState: 1)
				)
			)
			(11
				(gTheSoundFX number: 561 loop: 1 play:)
				(aPig setLoop: 4 cel: 0 setCycle: End self)
			)
			(12
				(RoomScript changeState: 11)
				(aPig setScript: 0 dispose:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((Said '//animal>')
				(cond 
					((> (aPig x?) 275) (proc255_0 540 42) (pEvent claimed: 1))
					((Said 'throw/*>')
						(if (Said '/bra')
							(pEvent claimed: 0)
						else
							(proc255_0 540 43)
							(pEvent claimed: 1)
						)
					)
					(else (proc255_0 540 44) (pEvent claimed: 1))
				)
			)
			((Said '/animal>')
				(cond 
					((> (aPig x?) 280) (proc255_0 540 42) (pEvent claimed: 1))
					((Said 'feed/') (proc255_0 540 45))
					((Said 'attack,carve/') (proc255_0 540 46))
					((Said 'address') (proc255_0 540 47))
					((Said 'look/') (proc255_0 540 48))
					(else (proc255_0 540 49) (pEvent claimed: 1))
				)
			)
		)
	)
)
