;;; Sierra Script 1.0 - (do not remove this comment)
(script# 460)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm460 0
)
(synonyms
	(man attendant arnold)
)

(local
	local0
	local1
)
(instance rm460 of Rm
	(properties
		picture 460
		north 470
		west 400
	)
	
	(method (init)
		(Load rsVIEW (+ 715 (* 100 global108)))
		(Load rsSCRIPT 969)
		(Load rsSOUND 460)
		(Load rsSOUND 461)
		(super init:)
		(gAddToPics add: atpDoor doit:)
		(if (not global108) (aMan init:))
		(aButton setPri: 9 init: stopUpd:)
		(aLightLeft setScript: (LightScript new:) init:)
		(aLightRight setScript: (LightScript new:) init:)
		(aDoor setCel: 0 ignoreActors: init: stopUpd:)
		(self setLocales: (+ 80 global108) setScript: RoomScript)
		(proc0_1)
		(User canInput: 0 mapKeyToDir: 0)
		(if (== gGNumber 470)
			(proc0_3)
			(gEgo illegalBits: 0 posn: 70 133 loop: 2 init:)
			(aDoor setCel: 255)
			(aLightLeft setCel: 0)
			(RoomScript changeState: 13)
		else
			(gEgo posn: 1 164 init:)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(= gGNumber_2 15)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 94 139 self
				)
			)
			(2
				(gEgo
					cycleSpeed: 1
					view: (+ 715 (* 100 global108))
					setLoop: 2
					setCycle: End self
				)
			)
			(3
				(aButton setCel: 1 stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(4
				(proc0_1 3)
				(proc0_3)
				((aLightLeft script?) changeState: 3)
			)
			(5 (= seconds 0))
			(6
				(aLightLeft setScript: 0)
				(gTheSoundFX number: 460 loop: 1 play:)
				(aDoor setCycle: End self)
			)
			(7
				(aDoor stopUpd:)
				(= cycles 10)
			)
			(8
				(gEgo illegalBits: 0 setMotion: MoveTo 70 135 self)
			)
			(9
				(gEgo setMotion: MoveTo 72 128 self)
			)
			(10
				(gEgo setLoop: 2)
				(= cycles 14)
			)
			(11
				(gTheSoundFX number: 461 loop: 1 play:)
				(aDoor setCycle: Beg)
				(= seconds 3)
			)
			(12
				(gTheMusic fade:)
				(global2 newRoom: 470)
			)
			(13
				(gEgo setMotion: MoveTo 70 154 self)
			)
			(14
				(gTheSoundFX number: 461 loop: 1 play:)
				(aDoor setCycle: Beg self)
			)
			(15
				(aDoor stopUpd:)
				(proc0_1)
				(= gGNumber_2 0)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'drag')
					(Said 'get,use/elevator')
					(Said 'board,open/elevator,door')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (& (gEgo onControl:) $0002)) (proc255_0 460 0))
					(else (RoomScript changeState: 1))
				)
			)
			((Said 'look>')
				(cond 
					((Said '/palm') (proc255_0 460 1))
					((Said '/carpet,carpet') (proc255_0 460 2))
					((Said '/elevator,door,burn')
						(proc255_4
							460
							3
							(+ 1 (aLightLeft cel?))
							(+ 1 (aLightRight cel?))
						)
					)
					(
						(and
							global108
							(or (Said '/buffet,man') (Said '//buffet,man'))
						)
						(proc255_0 460 4)
					)
					((Said '[/area,area,hotel]')
						(proc255_4
							460
							5
							(if global108
								{}
							else
								{Un empleado se aburre detr*s del mostrador.}
							)
						)
					)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if (proc0_26 aButton (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_4
								460
								3
								(+ 1 (aLightLeft cel?))
								(+ 1 (aLightRight cel?))
							)
						)
						(995
							(cond 
								((!= gGNumber_2 0) (proc0_9))
								((not (& (gEgo onControl:) $0002)) (proc255_0 460 0))
								(else (RoomScript changeState: 1))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 aMan (pEvent x?) (pEvent y?))
						(gCast contains: aMan)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(proc255_0 460 10)
							(proc255_0 460 11 67 -1 144)
						)
						(996
							(cond 
								((& (gEgo onControl:) $0008) (proc255_0 460 7))
								((& (gEgo onControl:) $0004) (proc255_0 460 8) (ManScript changeState: 5))
								(12
									(proc255_0 460 9)
									(ManScript changeState: 5 register: 101)
								)
								(else (proc0_10))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 9)
						(> (pEvent y?) 136)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo -2 162)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance ManScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 4 8)))
			(1
				(aMan
					illegalBits: 0
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 257 162 self
				)
			)
			(2 (= seconds (Random 4 8)))
			(3
				(aMan setMotion: MoveTo 233 140 self)
			)
			(4 (self changeState: 0))
			(5
				(aMan setMotion: MoveTo 249 155 self)
			)
			(6
				(aMan cycleSpeed: 4 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(aMan setCel: 0)
				(= cycles 2)
			)
			(8
				(cond 
					(register
						(switch register
							(101 (proc255_0 460 12))
							(102 (proc255_0 460 13))
						)
					)
					(global108
						(switch local1
							(0 (proc255_0 460 14))
							(1 (proc255_0 460 15))
							(2 (proc255_0 460 16))
							(3 (proc255_0 460 17))
						)
						(if (> (++ local1) 3) (= local1 0))
					)
					(else
						(switch local1
							(0 (proc255_0 460 18))
							(1 (proc255_0 460 19))
							(2 (proc255_0 460 20))
							(3 (proc255_0 460 21))
						)
						(if (> (++ local1) 3) (= local1 0))
					)
				)
				(self changeState: 0)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			(
				(or
					(Said '/casino,gamble,gambling')
					(Said '//casino,gamble,gambling')
				)
				(proc255_0 460 6)
				(ManScript changeState: 5 register: 102)
			)
			((Said 'address')
				(cond 
					((& (gEgo onControl:) $0008) (proc255_0 460 7))
					((& (gEgo onControl:) $0004) (proc255_0 460 8) (ManScript changeState: 5))
					(else (proc0_10))
				)
			)
			(
				(and
					(not (Said 'look>'))
					(or
						(Said '/key,penthouse,area')
						(Said 'enroll')
						(Said '//key,penthouse,area')
					)
				)
				(proc255_0 460 9)
				(ManScript changeState: 5 register: 101)
			)
			((Said 'look/man,buffet,man') (proc255_0 460 10) (proc255_0 460 11 67 -1 144))
		)
	)
)

(instance aButton of Prop
	(properties
		y 117
		x 102
		view 460
		loop 1
	)
)

(instance aLightLeft of Prop
	(properties
		x 69
	)
)

(instance aLightRight of Prop
	(properties
		x 135
	)
)

(instance aDoor of Prop
	(properties
		y 132
		x 69
		view 460
		priority 9
	)
)

(instance atpDoor of PV
	(properties
		y 132
		x 135
		view 460
		priority 9
	)
)

(instance aMan of Act
	(properties
		y 140
		x 233
		view 462
		loop 1
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setPri: 4
			setCycle: Walk
			setScript: ManScript
		)
	)
)

(instance LightScript of Script
	(properties)
	
	(method (changeState newState &tmp clientCel)
		(switch (= state newState)
			(0
				(client
					view: 460
					setCel: (Random 2 9)
					setLoop: 2
					cycleSpeed: 2
					setPri: 9
					y: 60
				)
				(= seconds 3)
			)
			(1 (= seconds (Random 4 10)))
			(2
				(= clientCel (client cel?))
				(while (== (client cel?) clientCel)
					(= clientCel (Random 1 8))
				)
				(client
					setCycle: CT clientCel (if (> clientCel (client cel?)) 1 else -1) self
				)
				(= state 0)
			)
			(3
				(if (== (client cel?) 0)
					(client setCel: 0)
					(= state 5)
				)
				(= seconds 3)
			)
			(4
				(client cycleSpeed: 2 setCycle: CT 0 -1 self)
			)
			(5 (= seconds 3))
			(6 (RoomScript changeState: 6))
		)
	)
)
