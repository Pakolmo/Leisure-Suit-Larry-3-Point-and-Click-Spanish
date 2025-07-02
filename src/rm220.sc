;;; Sierra Script 1.0 - (do not remove this comment)
(script# 220)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm220 0
)

(local
	local0
	[local1 222]
)
(procedure (localproc_000c &tmp temp0)
	(proc255_0
		@local1
		67
		10
		5
		70
		290
		25
		(= temp0 (proc0_25 @local1))
		88
	)
	(return (+ 3 temp0))
)

(instance rm220 of Rm
	(properties
		picture 220
		horizon 67
		north 310
	)
	
	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(if (and (proc0_22 21) (not (proc0_22 28)))
			(Load rsVIEW 220)
			(Load rsVIEW 221)
			(Load rsFONT 9)
			(Load rsSOUND 110)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(cond 
			((== gGNumber 300) (gEgo posn: 6 175))
			((== gGNumber 210) (gEgo posn: 2 151))
			((== gGNumber 310) (gEgo posn: 316 70))
			((== gGNumber 230) (gEgo posn: 316 142))
			(else (gEgo posn: 316 182))
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (gEgo edgeHit?)
			(cond 
				((& (gEgo onControl:) $0002) (global2 newRoom: 300))
				((& (gEgo onControl:) $0004) (global2 newRoom: 210))
				((& (gEgo onControl:) $0008) (global2 newRoom: 310))
				((& (gEgo onControl:) $0010) (global2 newRoom: 230))
				((& (gEgo onControl:) $0020) (global2 newRoom: 250))
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 5))
			(1
				(cond 
					((not (proc0_22 20))
						(proc0_3)
						(proc255_0 220 2)
						(gEgo loop: 1)
						(Animate (gCast elements?) 0)
						(global2 newRoom: 210)
					)
					((not (proc0_22 21)) (proc0_3) (= cycles 25))
				)
			)
			(2
				(Format @local1 220 3)
				(gEgo setMotion: MoveTo 8 153 self)
				(= seconds (localproc_000c))
			)
			(3)
			(4
				(Format @local1 220 4)
				(= seconds (localproc_000c))
			)
			(5
				(Format @local1 220 5)
				(= seconds (localproc_000c))
			)
			(6
				(Format @local1 220 6)
				(= seconds (localproc_000c))
			)
			(7
				(Format @local1 220 7)
				(= seconds (localproc_000c))
			)
			(8
				(Format @local1 220 8)
				(= seconds (localproc_000c))
			)
			(9
				(Format @local1 220 9)
				(gEgo setMotion: MoveTo 85 153 self)
				(= seconds (localproc_000c))
			)
			(10)
			(11
				(Format @local1 220 10)
				(gTheMusic fade:)
				(= seconds (localproc_000c))
			)
			(12
				(Format @local1 220 11)
				(= seconds (localproc_000c))
			)
			(13
				(aBooth init: setMotion: MoveTo 111 153 self)
				(if (> global87 39)
					(gTheMusic number: 110 loop: 1 play:)
				)
			)
			(14
				(gEgo loop: 2)
				(= cycles 22)
			)
			(15
				(gEgo loop: 3)
				(= cycles 22)
			)
			(16
				(gEgo setPri: 10 setMotion: MoveTo 107 153 self)
			)
			(17
				(if (<= global87 39)
					(gTheMusic number: 110 loop: 1 play:)
				)
				(gEgo view: 221 loop: 1 cel: 0 setCycle: End self)
			)
			(18
				(gEgo
					loop: 2
					cel: 0
					posn: (gEgo x?) (- (gEgo y?) 16)
					setCycle: End self
				)
			)
			(19 (= cycles 22))
			(20
				(gEgo view: 221 loop: 3 cel: 0 setCycle: End self)
			)
			(21
				(proc255_0 220 12 67 -1 10 33 9 25 3 88)
				(ShakeScreen 7 3)
				(= seconds 5)
			)
			(22
				(= global66 700)
				(proc0_1 1)
				(proc0_3)
				(gEgo
					posn: (gEgo x?) (+ (gEgo y?) 16)
					setPri: 10
					setMotion: MoveTo 85 153 self
				)
			)
			(23 (= cycles 22))
			(24
				(aBooth setMotion: MoveTo 111 211 self)
				(= cycles 33)
			)
			(25
				(proc0_19 21)
				(gEgo setMotion: MoveTo 107 153 self)
				(Format @local1 220 13)
				(= seconds (localproc_000c))
			)
			(26 (= cycles 33))
			(27 (aBooth stopUpd:))
			(28
				(proc0_1 0)
				(proc0_24 3 210)
				(proc0_24 1 216)
				(= gGNumber_2 0)
				(gTheMusic number: 299 loop: global72 play:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				(or
					(and
						(== (pEvent message?) KEY_RETURN)
						(== (pEvent type?) evKEYBOARD)
					)
					(== (pEvent type?) evMOUSEBUTTON)
				)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(if (Said '/building,office,club') (proc255_0 220 0))
			(if (Said '[/area]') (proc255_0 220 1))
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 238)
					(< (pEvent x?) 305)
					(> (pEvent y?) 80)
					(< (pEvent y?) 107)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 321 73)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 284)
					(< (pEvent x?) 319)
					(> (pEvent y?) 114)
					(< (pEvent y?) 144)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 321 137)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 6)
					(< (pEvent x?) 311)
					(> (pEvent y?) 21)
					(< (pEvent y?) 181)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 220 1))
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 0)
					(< (pEvent x?) 19)
					(> (pEvent y?) 137)
					(< (pEvent y?) 155)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -3 145)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 0)
					(< (pEvent x?) 18)
					(> (pEvent y?) 164)
					(< (pEvent y?) 184)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -3 175)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 302)
					(< (pEvent x?) 319)
					(> (pEvent y?) 173)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 322 183)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 220
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
		view 220
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
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit2 loop: 2 setCycle: End)
				(= cycles 22)
			)
			(5
				(proc0_19 28)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(6
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

(instance aBooth of Act
	(properties
		y 211
		x 111
		view 221
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setLoop: 0 setPri: 11)
	)
)
