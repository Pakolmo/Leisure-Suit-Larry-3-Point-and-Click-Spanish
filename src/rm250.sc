;;; Sierra Script 1.0 - (do not remove this comment)
(script# 250)
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
	rm250 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 200]
)
(procedure (localproc_000c &tmp temp0)
	(proc255_0
		@local5
		67
		10
		5
		70
		290
		25
		(= temp0 (proc0_25 @local5))
		88
	)
	(return (+ 3 temp0))
)

(instance rm250 of Rm
	(properties
		picture 250
		south 260
	)
	
	(method (init)
		(if
		(and (gEgo has: 2) (== ((Inv at: 2) view?) 2))
			(Load rsVIEW 251)
			(Load rsVIEW 709)
			(Load rsVIEW 2)
			(Load rsSOUND 250)
		)
		(if (== gGNumber_2 4) (self style: 7))
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(self setScript: RoomScript)
		(if (not (proc0_22 22)) (Load rsVIEW 53))
		(if (and (proc0_22 22) (not (proc0_22 29)))
			(Load rsVIEW 252)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(if (> global87 16) (aFountain init:))
		(cond 
			((== gGNumber 305) (gEgo posn: 2 186) (= local3 1))
			((== gGNumber 220) (gEgo posn: 2 122))
			((== gGNumber 253) (gEgo posn: 317 125))
			((== gGNumber 260) (gEgo posn: 154 187 loop: 3))
			(else (= local0 1) (gEgo posn: 317 118 loop: 1))
		)
		(proc0_1)
		(if local0
			(gEgo setPri: 11 observeControl: 16384 init:)
		else
			(gEgo observeControl: 8192 init:)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (gEgo edgeHit?)
			(cond 
				((& (gEgo onControl:) $0002) (global2 newRoom: 305))
				((& (gEgo onControl:) $0008) (global2 newRoom: 220))
				((& (gEgo onControl:) $0010)
					(if local0
						(global2 newRoom: 400)
					else
						(global2 newRoom: 253)
					)
				)
			)
		)
		(cond 
			((== local0 -1))
			((& (gEgo onControl:) $1000) (= local0 1))
			((& (gEgo onControl:) $0800) (= local0 0))
		)
		(if (== local0 1)
			(gEgo
				setPri: 11
				observeControl: 16384
				ignoreControl: 8192
			)
		)
		(if (== local0 0)
			(gEgo
				setPri: -1
				ignoreControl: 16384 16
				observeControl: 8192
			)
		)
		(if
			(and
				(& (gEgo onControl:) $0002)
				(or global108 (!= gGNumber_2 0))
			)
			(if (not local3)
				(= local3 1)
				(gEgo
					posn: (gEgo xLast?) (gEgo yLast?)
					setMotion: 0
					observeControl: 2
				)
				(if global108 (proc255_0 250 0) else (proc255_0 250 1))
				(Animate (gCast elements?) 0)
			)
		else
			(= local3 0)
		)
		(if
			(and
				(& (gEgo onControl:) $0010)
				local0
				(!= gGNumber_2 11)
				(!= gGNumber_2 0)
			)
			(if (not local2)
				(= local2 1)
				(gEgo
					posn: (gEgo xLast?) (gEgo yLast?)
					setMotion: 0
					observeControl: 16
				)
				(proc255_0 250 2)
				(Animate (gCast elements?) 0)
			)
		else
			(= local2 0)
		)
		(if (& (gEgo onControl:) $0004)
			(if (not local1)
				(= local1 1)
				(ShakeScreen 1 2)
				(proc255_0 250 3)
				(proc255_0 250 4 67 -1 144)
			)
		else
			(= local1 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_22 22)) (= cycles 25))
			)
			(1
				(Format @local5 250 15)
				(= seconds (localproc_000c))
				(aCredit1 view: 53 posn: 0 156 setCycle: Fwd init:)
				(= seconds 13)
			)
			(2
				(Format @local5 250 16)
				(= seconds (localproc_000c))
			)
			(3
				(Format @local5 250 17)
				(= seconds (localproc_000c))
			)
			(4
				(proc0_19 22)
				(Format @local5 250 18)
				(= seconds (localproc_000c))
			)
			(5
				(aCredit1 dispose:)
				(= seconds 0)
			)
			(6
				(proc0_6)
				(proc0_3)
				(= local0 -1)
				(gEgo illegalBits: 0 setMotion: MoveTo 278 134 self)
			)
			(7
				(gEgo
					view: 709
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(8
				(proc255_0 250 19 82 2 0 0)
				(= local4 0)
				(= seconds 2)
				(= global101 (gGame setSpeed: 6))
			)
			(9
				(gTheSoundFX number: 250 loop: 1 play:)
				(gEgo view: 251 cel: 0 setCycle: End)
				(= cycles 7)
				(if (< (++ local4) 11) (-- state))
			)
			(10
				((Inv at: 2) view: 21)
				(Format ((Inv at: 2) name?) 250 20)
				(gTheSoundFX stop:)
				(gGame setSpeed: global101 changeScore: 50)
				(gEgo view: 709 loop: 0 setCel: 255 setCycle: Beg self)
			)
			(11
				(proc0_1)
				(= local0 0)
				(proc255_0 250 21)
				(proc255_0 250 22)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				(== (pEvent message?) KEY_RETURN)
				(== (pEvent type?) evKEYBOARD)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(if (pEvent claimed?) (return))
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
			)
			(if
				(and
					(> (pEvent x?) 180)
					(< (pEvent x?) 243)
					(> (pEvent y?) 107)
					(< (pEvent y?) 152)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(2 (proc255_0 250 6))
					(998 (proc255_0 250 12))
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 1)
					(< (pEvent x?) 319)
					(> (pEvent y?) 21)
					(< (pEvent y?) 79)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 250 14))
					(else  (pEvent claimed: 0))
				)
			)
			(if (proc0_27 275 317 101 137 pEvent)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998 (proc255_0 250 13))
					(2
						(cond 
							((not (gEgo has: 2)) (proc0_12))
							((== ((Inv at: 2) view?) 21) (proc0_7))
							((not local0) (proc255_0 250 8))
							((!= gGNumber_2 0) (proc0_9))
							(else (self changeState: 6))
						)
					)
					(999
						(gEgo setMotion: MoveTo 322 100)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 93)
					(< (pEvent x?) 214)
					(> (pEvent y?) 175)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 146 195)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 312)
					(< (pEvent x?) 318)
					(> (pEvent y?) 103)
					(< (pEvent y?) 151)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 319 126)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 0)
					(< (pEvent x?) 10)
					(> (pEvent y?) 104)
					(< (pEvent y?) 124)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -4 115)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 0)
					(< (pEvent x?) 7)
					(> (pEvent y?) 151)
					(< (pEvent y?) 166)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo -5 172)
					)
					(else  (pEvent claimed: 0))
				)
			)
			(if
				(and
					(> (pEvent x?) 290)
					(< (pEvent x?) 319)
					(> (pEvent y?) 78)
					(< (pEvent y?) 114)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(999
						(gEgo setMotion: MoveTo 322 115)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
)

(instance aFountain of Prop
	(properties
		y 148
		x 194
		view 250
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd setPri: 11)
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 240
		view 252
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
		view 252
		loop 1
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
			(0 (= seconds 3))
			(1
				(aCredit1 setCycle: End)
				(= cycles 13)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 16)
			)
			(3
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit2 loop: 2 setCycle: End)
				(= cycles 16)
			)
			(5
				(aCredit2 setCycle: Beg self)
			)
			(6
				(aCredit2 loop: 3 setCycle: End)
				(= cycles 16)
			)
			(7
				(aCredit2 setCycle: Beg self)
			)
			(8
				(aCredit2 loop: 4 setCycle: End)
				(= cycles 16)
			)
			(9
				(proc0_19 29)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(10
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)
