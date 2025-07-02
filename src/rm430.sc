;;; Sierra Script 1.0 - (do not remove this comment)
(script# 430)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Jump)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm430 0
)

(local
	theAActor4_2
	theAActor3_2
	theAActor5_2
	local3
	theAMoney1
	theAMoney2
	theAMoney3
	theAMoney4
	theAMoney5
	local9
	theAActor1
	theAActor2
	theAActor3
	theAActor4
	theAActor5
	[local15 12] = [0 0 54 74 41 78 26 83 11 88 -4 93]
)
(instance rm430 of Rm
	(properties
		picture 430
		horizon 1
	)
	
	(method (init &tmp temp0)
		(= global104 1)
		(= gGGNumber_2 gGNumber_2)
		(= gGNumber_2 gNumber)
		(proc0_3)
		(Load rsVIEW 432)
		(Load rsSOUND 431)
		(Load rsSOUND 13)
		(Load rsSOUND 10)
		(Load rsSCRIPT 991)
		(Load rsPIC 431)
		(gTheMusic number: 430 loop: -1 play:)
		(super init:)
		(aCurtain ignoreActors: init:)
		(aActor1 ignoreActors: init:)
		(aActor2 ignoreActors: init:)
		(aActor3 ignoreActors: init:)
		(aActor4 ignoreActors: init:)
		(aActor5 ignoreActors: init:)
		(= global101 (gGame setSpeed: 6))
		(= theAActor1 aActor1)
		(= theAActor2 aActor2)
		(= theAActor3 aActor3)
		(= theAActor4 aActor4)
		(= theAActor5 aActor5)
		(aMoney1 ignoreActors: init:)
		(aMoney2 ignoreActors: init:)
		(aMoney3 ignoreActors: init:)
		(aMoney4 ignoreActors: init:)
		(aMoney5 ignoreActors: init:)
		(= theAMoney1 aMoney1)
		(= theAMoney2 aMoney2)
		(= theAMoney3 aMoney3)
		(= theAMoney4 aMoney4)
		(= theAMoney5 aMoney5)
		(= theAActor3_2 aActor3)
		(= theAActor4_2 aActor4)
		(= theAActor5_2 aActor5)
		(gEgo posn: 999 999 init: hide:)
		(= temp0 1)
		(while (<= temp0 5)
			([local9 temp0]
				view: 433
				posn: [local15 (* temp0 2)] [local15 (+ 1 (* temp0 2))]
				setPri: 3
				setStep: 1 1
			)
			(++ temp0)
		)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState &tmp temp0)
		(proc21_1 self newState 1 12)
		(switch (= state newState)
			(0
				(theAActor1 setCycle: End self)
			)
			(1
				(theAActor1 cel: 0 setCycle: End)
				(theAActor2 setCycle: End self)
			)
			(2
				(theAActor1 cel: 0 setCycle: End)
				(theAActor2 cel: 0 setCycle: End)
				(theAActor3 setCycle: End self)
			)
			(3
				(theAActor1 cel: 0)
				(theAActor2 cel: 0 setCycle: End)
				(theAActor3 cel: 0 setCycle: End)
				(theAActor4 setCycle: End self)
			)
			(4
				(proc255_0 430 0 67 10 144 70 290 88)
				(theAActor2 cel: 0)
				(theAActor3 cel: 0 setCycle: End)
				(theAActor4 cel: 0 setCycle: End)
				(theAActor5 setCycle: End self)
			)
			(5
				(theAActor3 cel: 0)
				(theAActor4 cel: 0 setCycle: End)
				(theAActor5 cel: 0 setCycle: End self)
			)
			(6
				(theAActor4 cel: 0)
				(theAActor5 setCycle: End self)
			)
			(7
				(theAActor5 cel: 0 setCycle: End self)
			)
			(8
				(theAActor4 cel: 0 setCycle: End self)
			)
			(9
				(theAActor3 cel: 0 setCycle: End self)
			)
			(10
				(theAActor2 cel: 0 setCycle: End self)
			)
			(11
				(theAActor1 cel: 0 setCycle: End self)
			)
			(12
				(theAActor2 setCycle: End self)
			)
			(13
				(theAActor3 setCycle: End self)
			)
			(14
				(theAActor4 setCycle: End self)
			)
			(15
				(theAActor5 setCycle: End self)
			)
			(16
				(theAActor4 setCycle: End self)
			)
			(17
				(theAActor3 setCycle: End self)
			)
			(18
				(theAActor2 setCycle: End self)
			)
			(19
				(proc0_5)
				(theAActor1 setCycle: End self)
			)
			(20
				(theAActor1 setCycle: End self)
				(theAActor2 setCycle: Fwd)
			)
			(21
				(theAActor1 setCycle: End self)
				(theAActor3 setCycle: Fwd)
			)
			(22
				(theAActor1 setCycle: End self)
				(theAActor4 setCycle: Fwd)
			)
			(23
				(theAActor1 setCycle: Fwd)
				(theAActor5 setCycle: Fwd)
				(= cycles 55)
			)
			(24
				(= temp0 1)
				(while (<= temp0 5)
					([local9 temp0] setMotion: MoveTo 119 52)
					(++ temp0)
				)
				(= cycles 66)
			)
			(25
				(gTheMusic fade:)
				(= cycles 66)
			)
			(26
				(gTheMusic number: 10 loop: -1 play:)
				(proc255_0 430 1 67 10 5 70 290)
				(theAActor1 dispose:)
				(theAActor2 dispose:)
				(theAActor3_2
					view: 430
					setLoop: 3
					posn: 167 97
					setPri: 2
					hide:
				)
				(theAActor4_2
					view: 430
					setLoop: 4
					posn: 148 163
					setPri: 3
					hide:
				)
				(theAActor5_2
					view: 432
					setLoop: 0
					setCel: 0
					posn: 149 140
					setPri: 4
					hide:
				)
				(= cycles 22)
			)
			(27
				(global2 drawPic: 431 8)
				(aSpotlight
					loop: 1
					setCel: 1
					posn: 160 45
					setPri: 1
					ignoreActors:
					init:
					stopUpd:
				)
				(aFloor
					loop: 2
					setCel: 1
					posn: 152 102
					setPri: 6
					ignoreActors:
					init:
					stopUpd:
				)
				(theAActor4_2 show:)
				(theAActor5_2 show:)
				(= cycles 11)
			)
			(28
				(theAActor3_2 show: setMotion: MoveTo 149 97 self)
			)
			(29
				(theAActor3_2 stopUpd:)
				(theAActor5_2 setMotion: MoveTo 149 86)
				(theAActor4_2 setMotion: MoveTo 148 109 self)
			)
			(30
				(theAActor4_2 stopUpd:)
				(gTheMusic number: 431 loop: -1 play:)
				(theAActor5_2 setLoop: 3 setCycle: Fwd)
				(= cycles 33)
			)
			(31
				(theAActor5_2 setLoop: 4)
				(= cycles 33)
			)
			(32
				(theAActor5_2 cel: 0 setCycle: End self)
			)
			(33
				(theAActor5_2 setLoop: 1 setCycle: Fwd)
				(proc255_0 430 2 67 10 144 70 290 88)
				(= temp0 1)
				(while (<= temp0 5)
					([local3 temp0] setScript: (MoneyScript new:))
					(++ temp0)
				)
				(self cue:)
			)
			(34
				(= cycles (* 2 (NumCels theAActor5_2)))
				(if (> gNewSpeed 1)
					(gGame setSpeed: (-- gNewSpeed))
					(-- state)
				)
			)
			(35
				(proc0_5)
				(theAActor5_2 setCycle: Fwd)
				(= cycles 261)
			)
			(36
				(if 0
					(self cue:)
				else
					(aSpotlight setCycle: Fwd)
					(aFloor setCycle: Fwd)
					(= cycles 261)
				)
			)
			(37
				(aSpotlight setCel: 1 stopUpd:)
				(aFloor setCel: 1 stopUpd:)
				(self cue:)
			)
			(38
				(= cycles (* 2 (NumCels theAActor5_2)))
				(if (< gNewSpeed 6)
					(gGame setSpeed: (++ gNewSpeed))
					(-- state)
				)
			)
			(39
				(theAActor5_2 setLoop: 2 setCycle: End self)
			)
			(40
				(theAActor5_2 setCel: 255)
				(gTheMusic fade:)
				(= seconds 4)
			)
			(41
				(proc255_0 430 3 67 10 5 70 290)
				(gTheMusic number: 13 loop: -1 play:)
				(theAActor4_2 setMotion: MoveTo 148 163)
				(theAActor5_2 setMotion: MoveTo 149 140 self)
				(= temp0 1)
				(while (<= temp0 5)
					(([local3 temp0] script?) changeState: 2)
					(++ temp0)
				)
			)
			(42
				(gTheMusic fade:)
				(proc255_0 430 4 67 10 5 70 290)
				(theAActor3_2 setMotion: MoveTo 167 97 self)
			)
			(43
				(global2 drawPic: 430 8)
				(theAActor3_2 dispose:)
				(aSpotlight dispose:)
				(aFloor dispose:)
				(Animate (gCast elements?) 0)
				(proc255_0 430 5 67 10 5 70 290)
				(= seconds 3)
			)
			(44
				(proc255_0 430 6)
				(proc255_0 430 7 67 -1 144)
				(= seconds 2)
			)
			(45
				(gGame setSpeed: global101)
				(= gGNumber_2 gGGNumber_2)
				(global2 newRoom: 420)
			)
		)
	)
)

(instance aActor1 of Act
	(properties)
)

(instance aActor2 of Act
	(properties)
)

(instance aActor3 of Act
	(properties)
)

(instance aActor4 of Act
	(properties)
)

(instance aActor5 of Act
	(properties)
)

(instance aSpotlight of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aFloor of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aCurtain of Prop
	(properties
		y 63
		x 15
		view 430
		cycleSpeed 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 2 ignoreActors: stopUpd:)
	)
)

(instance aMoney1 of Act
	(properties)
)

(instance aMoney2 of Act
	(properties)
)

(instance aMoney3 of Act
	(properties)
)

(instance aMoney4 of Act
	(properties)
)

(instance aMoney5 of Act
	(properties)
)

(instance MoneyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 430 setLoop: 7 setCycle: Fwd setStep: 7 7)
				(= cycles (Random 1 9))
			)
			(1
				(client
					posn: (Random 8 290) (Random 144 157)
					setMotion:
						JumpTo
						(theAActor5_2 x?)
						(- (theAActor5_2 y?) (Random 0 33))
						self
				)
				(-- state)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)
