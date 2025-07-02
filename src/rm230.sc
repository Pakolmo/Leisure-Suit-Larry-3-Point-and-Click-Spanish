;;; Sierra Script 1.0 - (do not remove this comment)
(script# 230)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use DCIcon)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm230 0
)
(synonyms
	(man guard man man man bouncer)
)

(local
	local0
	local1
	[local2 200]
)
(procedure (localproc_0026 param1 param2 param3)
	(proc255_0
		@local2
		67
		-1
		10
		80
		{El portero dice:}
		30
		1
		82
		param1
		param2
		param3
	)
	(= local2 0)
)

(instance rm230 of Rm
	(properties
		picture 230
		east 240
		south 220
	)
	
	(method (init)
		(if
			(and
				(proc0_23 4)
				(gEgo has: 2)
				(== 21 ((Inv at: 2) view?))
			)
			(Load rsVIEW 231)
			(Load rsVIEW 21)
		)
		(super init:)
		(self setScript: RoomScript)
		(gAddToPics add: atpSign doit:)
		(aDoor init:)
		(if global108
			(aSign init:)
			(aDoorman init:)
			(Load rsSOUND 11)
			(if (gEgo has: 6) (Load rsVIEW 25))
		)
		(proc0_1)
		(gEgo init:)
		(User canInput: 0 mapKeyToDir: 0)
		(cond 
			((== gGNumber 220)
				(gEgo loop: 3)
				(switch (Random 1 3)
					(1 (gEgo posn: 52 188))
					(2 (gEgo posn: 135 188))
					(3 (gEgo posn: 212 188))
				)
			)
			((== gGNumber 240) (gEgo posn: 317 135 loop: 1))
			((== gGNumber 235) (gEgo posn: 100 128 loop: 0))
			((== gGNumber 330)
				(= gGNumber_2 0)
				(proc0_3)
				(aDoorman posn: 149 53 setCycle: Walk)
				(gEgo ignoreActors: illegalBits: 0 posn: 179 48 loop: 2)
				(aDoor setCel: 255)
				(DoormanScript changeState: 23)
			)
			(else (gEgo posn: 212 188))
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002) (global2 newRoom: 235))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(proc0_6)
				(gEgo setMotion: MoveTo 201 123 self)
			)
			(2
				(gEgo
					view: 231
					setLoop: (if (gEgo loop?) 1 else 0)
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: (+ (gEgo loop?) 2) setCycle: Fwd)
				(= cycles 20)
			)
			(4
				(proc255_0 230 16 67 -1 10 82 21 0 0)
				(= cycles 20)
			)
			(5
				(gEgo get: 4 setLoop: (+ (gEgo loop?) 2) setCycle: End)
				(= cycles 10)
			)
			(6
				(proc0_1 (- (gEgo loop?) 4))
				(gGame changeScore: 20)
				(proc255_0 230 17 67 -1 10)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'drag,break,get,break/blade')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					(global108 (proc255_0 230 0))
					((not (proc0_23 4)) (proc0_11))
					((not (& (gEgo onControl:) $0010)) (proc0_10))
					(else (proc255_0 230 0))
				)
			)
			((Said 'carve/blade>')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					(global108 (proc255_0 230 0))
					((not (proc0_23 4)) (proc0_11))
					((not (& (gEgo onControl:) $0010)) (proc0_10))
					(
					(or (not (Said '//ginsu')) (not (gEgo has: 2))) (proc255_0 230 1))
					((!= ((Inv at: 2) view?) 21) (proc255_0 230 2))
					(else (self changeState: 1))
				)
				(pEvent claimed: 1)
			)
			((Said 'use/ginsu>')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (gEgo has: 2)) (proc0_12))
					((not (proc0_23 4)) (proc0_11))
					((not (& (gEgo onControl:) $0010)) (proc0_10))
					((not (Said '//blade<carve')) (proc255_0 230 3))
					((!= ((Inv at: 2) view?) 21) (proc255_0 230 2))
					(else (self changeState: 1))
				)
				(pEvent claimed: 1)
			)
			((Said 'look>')
				(cond 
					((Said '/door,awning,club')
						(proc255_0 230 4 30 1)
						(if (not global108)
							(proc255_0 230 5)
						else
							(proc255_0 230 6 30 1)
						)
					)
					((Said '/boulder,cliff') (proc255_0 230 7))
					((and (proc0_23 4) (Said '/blade')) (proc255_0 230 8) (proc255_0 230 9 67 -1 144))
					((Said '/flower') (proc255_0 230 10))
					((Said '/palm') (proc255_0 230 11) (proc255_0 230 12 67 -1 144))
					((Said '[/area]')
						(if (gCast contains: aDoorman)
							(proc255_0 230 13)
						else
							(proc255_0 230 14)
							(proc255_0 230 15)
						)
					)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 164)
						(< (pEvent x?) 248)
						(> (pEvent y?) 95)
						(< (pEvent y?) 128)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(2
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (gEgo has: 2)) (proc0_12))
								((not (proc0_23 4)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc0_10))
								((!= ((Inv at: 2) view?) 21) (proc255_0 230 2))
								(else (self changeState: 1))
							)
							(pEvent claimed: 1)
						)
						(995
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								(global108 (proc255_0 230 0))
								((not (proc0_23 4)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc0_10))
								(
								(or (not (Said '//ginsu')) (not (gEgo has: 2))) (proc255_0 230 1))
								((!= ((Inv at: 2) view?) 21) (proc255_0 230 2))
								(else (self changeState: 1))
							)
							(pEvent claimed: 1)
						)
						(998
							(if (gCast contains: aDoorman)
								(proc255_0 230 13)
							else
								(proc255_0 230 14)
								(proc255_0 230 15)
							)
						)
						(21
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (gEgo has: 2)) (proc0_12))
								((not (proc0_23 4)) (proc0_11))
								((not (& (gEgo onControl:) $0010)) (proc0_10))
								((!= ((Inv at: 2) view?) 21) (proc255_0 230 2))
								(else (self changeState: 1))
							)
							(pEvent claimed: 1)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 90)
						(< (pEvent x?) 230)
						(> (pEvent y?) 174)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 136 192)
						)
						(998 (proc255_0 {OK}))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 306)
						(< (pEvent x?) 319)
						(> (pEvent y?) 96)
						(< (pEvent y?) 162)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 321 127)
						)
						(998 (proc255_0 {OK}))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 94)
						(< (pEvent x?) 118)
						(> (pEvent y?) 69)
						(< (pEvent y?) 133)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 50 138 self)
							(gEgo setMotion: MoveTo 45 138)
						)
						(998 (proc255_0 230 7))
						(995 (global2 newRoom: 235))
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 aDoorman (pEvent x?) (pEvent y?))
						(gCast contains: aDoorman)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(994
							(cond 
								((not (& (gEgo onControl:) $0020)) (proc0_10))
								((proc0_22 36) (proc255_0 230 20))
								((not local1) (= local1 1) (proc255_0 230 21))
								((< global88 3) (proc255_0 230 22) (proc255_0 230 23 67 -1 144))
								(else (DoormanScript changeState: 11))
							)
						)
						(996
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (& (gEgo onControl:) $0020)) (proc255_0 230 31))
								((proc0_22 36) (proc255_0 230 32))
								(else
									(proc255_0 230 33)
									(Format @local2 230 34)
									(DoormanScript changeState: 1)
								)
							)
						)
						(998
							(proc255_0 230 35)
							(proc255_0 230 36 67 -1 144)
						)
						(30
							(proc255_0 230 39)
							(Format @local2 230 40)
							(DoormanScript changeState: 1)
						)
						(14
							(Format @local2 230 41)
							(DoormanScript changeState: 1)
						)
						(15
							(Format @local2 230 41)
							(DoormanScript changeState: 1)
						)
						(16
							(Format @local2 230 41)
							(DoormanScript changeState: 1)
						)
						(17
							(Format @local2 230 41)
							(DoormanScript changeState: 1)
						)
						(18 (proc255_0 230 42))
						(25
							(if (proc0_22 36)
								(proc255_0 230 20)
							else
								(DoormanScript changeState: 3)
								(= gGCursorNumber 900)
								(gGame setCursor: 998 (HaveMouse))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aDoor (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(994 (pEvent claimed: 1))
						(996 (pEvent claimed: 1))
						(998
							(if global108
								(proc255_0 230 18)
							else
								(proc255_0 230 19)
							)
						)
						(995 (pEvent claimed: 1))
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aDoor of Prop
	(properties
		y 50
		x 179
		view 230
	)
	
	(method (init)
		(super init:)
		(self setPri: 1 stopUpd:)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(if (Said 'look/door')
			(if global108
				(proc255_0 230 18)
			else
				(proc255_0 230 19)
			)
		)
	)
)

(instance aSign of Prop
	(properties
		x 179
		view 230
		loop 1
		cycleSpeed 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 5 setCycle: Fwd)
	)
)

(instance atpSign of PV
	(properties
		x 179
		view 230
		loop 2
		priority 4
		signal $4000
	)
)

(instance aDoorman of Act
	(properties
		y 53
		x 179
		view 422
		loop 2
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self setScript: DoormanScript setPri: 1 stopUpd:)
	)
)

(instance DoormanScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(proc21_1 self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(aDoorman setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(aDoorman setCel: 0 stopUpd:)
				(if (not local2) (Format @local2 230 44))
				(localproc_0026 422 3 0)
				(proc0_4)
			)
			(3
				(proc0_3)
				(gGame changeScore: 43)
				(proc255_0 230 45 82 25 0 0)
				(= global94 0)
				(proc0_24 6)
				(aDoorman setLoop: 2 setCycle: Fwd)
				(= cycles 0)
				(= seconds 3)
			)
			(4
				(aDoorman setCel: 0 stopUpd:)
				(Format @local2 230 46)
				(localproc_0026 422 3 1)
				(= seconds 2)
			)
			(5
				(User canControl: 1)
				(aDoorman
					illegalBits: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 149 53 self
				)
				(aDoor setCycle: End)
			)
			(6
				(proc0_3)
				(aDoorman setLoop: 2 setCel: 0)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 179 57 self
				)
			)
			(7
				(gEgo setMotion: MoveTo 179 48 self setPri: 0)
				(if (proc0_22 65) (proc255_0 230 47))
			)
			(8 (aDoor setCycle: Beg self))
			(9
				(gTheSoundFX number: 11 loop: 1 play:)
				(= cycles 5)
			)
			(10 (global2 newRoom: 330))
			(11
				(proc0_3)
				(proc255_0 230 48)
				(aDoorman setLoop: 2 setCel: 0)
				(= cycles 0)
				(= seconds 3)
			)
			(12
				(Format @local2 230 49)
				(localproc_0026 422 3 1)
				(= seconds 3)
			)
			(13
				(Format @local2 230 50)
				(localproc_0026 422 3 6)
				(= seconds 3)
			)
			(14
				(User canControl: 1)
				(aDoorman
					illegalBits: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 144 53 self
				)
			)
			(15
				(proc0_3)
				(aDoorman setLoop: 2 setCel: 0 stopUpd:)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 144 57 self
				)
			)
			(16
				(gEgo
					setLoop: 3
					setCel: 0
					setPri:
					setMotion: MoveTo 144 77 self
				)
			)
			(17 (= seconds 3))
			(18
				(BJicon view: 422 loop: 3)
				(proc255_0
					230
					51
					67
					-1
					10
					80
					{El portero Dice}
					30
					1
					82
					BJicon
				)
				(= seconds 3)
			)
			(19
				(gEgo setMotion: MoveTo 144 57 self)
			)
			(20
				(proc255_0 230 52)
				(= seconds 3)
			)
			(21
				(Format @local2 230 53)
				(localproc_0026 422 3 9)
				(aDoorman
					setLoop: -1
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 179 53 self
				)
			)
			(22
				(proc0_19 65)
				(proc255_0 230 54)
				(gEgo setLoop: -1 setCel: -1 setPri: -1 setCycle: Walk)
				(= cycles 12)
				(= state 4)
			)
			(23
				(gEgo setMotion: MoveTo 186 60 self)
			)
			(24 (aDoor setCycle: Beg self))
			(25
				(gTheSoundFX number: 11 loop: 1 play:)
				(aDoor stopUpd:)
				(aDoorman setMotion: MoveTo 179 53 self)
			)
			(26
				(aDoorman loop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(27
				(aDoorman setCel: 0 stopUpd:)
				(proc0_1)
				(proc255_0 230 55)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp gInvSaidMe)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			(
				(or
					(Said 'give/job<blow')
					(Said 'give/blow<job')
					(Said 'give/head')
					(Said 'affirmative')
					(Said 'give/head<job')
					(Said 'eat,blow,eat,eat/man,ball,coconut,ball')
				)
				(cond 
					((not (& (gEgo onControl:) $0020)) (proc0_10))
					((proc0_22 36) (proc255_0 230 20))
					((not local1) (= local1 1) (proc255_0 230 21))
					((< global88 3) (proc255_0 230 22) (proc255_0 230 23 67 -1 144))
					(else (self changeState: 11))
				)
			)
			(
				(or
					(Said 'board/club,area,backstage')
					(Said 'ask/dale,chip,show')
					(Said 'look/show')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0020)) (proc255_0 230 24))
					(else
						(proc255_4 230 25)
						(Format @local2 230 26)
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said 'bracelet,give,show/pass/man')
					(Said 'bracelet,give,show/man/pass')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0020)) (proc255_0 230 27))
					(else
						(proc255_0 230 28)
						(Format @local2 230 29)
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said 'bracelet,give,show/buck,bill/man')
					(Said 'buy,tip/man')
					(Said 'bracelet,give,show/man/buck,bill')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((proc0_22 36) (proc255_0 230 20))
					((not (gEgo has: 6)) (proc255_0 230 30))
					((not (& (gEgo onControl:) $0020)) (proc255_0 230 27))
					(else (self changeState: 3))
				)
			)
			((Said 'address/man')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0020)) (proc255_0 230 31))
					((proc0_22 36) (proc255_0 230 32))
					(else
						(proc255_0 230 33)
						(Format @local2 230 34)
						(self changeState: 1)
					)
				)
			)
			((Said 'look/man') (proc255_0 230 35) (proc255_0 230 36 67 -1 144))
			((Said 'give>')
				(= gInvSaidMe (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((not (& (gEgo onControl:) $0020)) (proc0_10))
					((Said '[/!*]') (proc255_0 230 37))
					((not gInvSaidMe) (proc255_0 230 38))
					((not (gInvSaidMe ownedBy: gEgo)) (proc0_12))
					((== gInvSaidMe (gInv at: 12))
						(proc255_0 230 39)
						(Format @local2 230 40)
						(self changeState: 1)
					)
					(
						(or
							(== gInvSaidMe (gInv at: 14))
							(== gInvSaidMe (gInv at: 15))
							(== gInvSaidMe (gInv at: 16))
							(== gInvSaidMe (gInv at: 17))
						)
						(Format @local2 230 41)
						(self changeState: 1)
					)
					((== gInvSaidMe (gInv at: 18)) (proc255_0 230 42))
					((not (== gInvSaidMe (gInv at: 6))) (proc255_0 230 43))
					(else (self changeState: 3))
				)
				(pEvent claimed: 1)
			)
		)
	)
)

(instance BJicon of DCIcon
	(properties)
	
	(method (init)
		(super init:)
		(if cycler (cycler dispose:))
		((= cycler (End new:)) init: self)
	)
)
