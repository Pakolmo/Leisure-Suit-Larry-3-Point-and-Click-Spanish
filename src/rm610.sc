;;; Sierra Script 1.0 - (do not remove this comment)
(script# 610)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Follow)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm610 0
)

(instance rm610 of Rm
	(properties
		picture 610
		east 620
	)
	
	(method (init)
		(proc0_3)
		(proc0_19 3)
		(proc0_19 5)
		(proc0_19 4)
		(= global101 (gGame setSpeed: 6))
		(= global108 1)
		(= global66 801)
		(= global82 (Format @global83 610 0))
		(super init:)
		(gAddToPics
			add: atpSign
			add: atpStencil1
			add: atpStencil2
			add: atpHouse1
			add: atpHouse2
			add: atpHouse3
			add: atpHouse4
			add: atpHouse5
			add: atpHouse6
			add: atpHouse7
			doit:
		)
		(self setScript: RoomScript)
		(proc0_3)
		(User canInput: 0 mapKeyToDir: 0)
		(Load rsSOUND 4)
		(Load rsSOUND 5)
		(Load rsSOUND 6)
		(Load rsSOUND 12)
		(Load rsSOUND 611)
		(Load rsSOUND 699)
		(aMan1 init:)
		(aMan2 init:)
		(aCar1 init:)
		(aCar2 init:)
		(aTowers init:)
		(aHole init:)
		(aCamera init:)
		(gEgo
			illegalBits: 0
			posn: 171 -50
			view: 804
			setLoop: 0
			setPri: 14
			setCycle: Walk
			setStep: 1 11
			init:
		)
		(aLarry
			ignoreHorizon:
			illegalBits: 0
			posn: 73 -70
			view: 631
			setLoop: 1
			setPri: 9
			setCycle: Walk
			setStep: 1 11
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002) (global2 newRoom: 620))
	)
	
	(method (changeState newState)
		(proc21_1 self newState 5 2)
		(switch (= state newState)
			(0
				(if (< gGNumber gNumber) (= seconds 3))
			)
			(1
				(proc255_0 610 5 67 10 40 70 290)
				(= seconds 3)
			)
			(2
				(proc255_0 610 6)
				(= seconds 2)
			)
			(3
				(proc255_0 610 7)
				(gTheMusic number: 610 loop: 1 play: self)
				(= seconds 3)
			)
			(4
				(proc255_0 610 8 25 2)
				(= seconds 3)
			)
			(5
				(proc255_0 610 9 25 2)
				(aCamera setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(proc255_0 610 10 25 2)
				(= seconds 3)
			)
			(7
				(aCamera setMotion: MoveTo 0 0 setCycle: Fwd)
				(aCar1 setMotion: MoveTo 0 129)
				(aMan1 setMotion: MoveTo 0 143)
				(Man2Script cue:)
			)
			(8
				(proc0_5)
				(proc255_0 610 11)
				(gTheMusic number: 4 loop: 1 play:)
				(aMan1
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 5 5
					setMotion: MoveTo -20 (aMan1 y?)
				)
				(aMan2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 5 5
					setMotion: MoveTo (aMan2 x?) 222
				)
				(aCar1 stopUpd:)
				(aCar2 stopUpd:)
				(aCamera stopUpd:)
				(gEgo setMotion: MoveTo 171 119 self)
			)
			(9
				(aHole dispose:)
				(gTheMusic number: 12 loop: 1 play:)
				(gEgo
					posn: 171 143
					setPri: 12
					setMotion: MoveTo 175 186 self
				)
			)
			(10
				(gEgo loop: 1 cel: 0 stopUpd:)
				(Animate (gCast elements?) 0)
				(gTheMusic number: 5 loop: 1 play:)
				(ShakeScreen 2 1)
				(= cycles 33)
			)
			(11
				(proc0_5)
				(gTheMusic number: 4 loop: 1 play:)
				(aLarry setMotion: MoveTo 73 73 self)
			)
			(12
				(aLarry posn: 73 89 view: 611 setLoop: 0 setStep: 2 1)
				(gTheMusic number: 12 loop: 1 play:)
				(Animate (gCast elements?) 0)
				(ShakeScreen 1 1)
				(proc255_0 610 12 67 -1 10 88)
				(= cycles 11)
			)
			(13
				(gTheMusic number: 6 loop: -1 play:)
				(proc0_5)
				(proc255_0 610 13 67 148 22 88)
				(aLarry setMotion: MoveTo 169 109 self)
			)
			(14
				(aMan1 dispose:)
				(aMan2 dispose:)
				(gTheMusic number: 611 loop: -1 play:)
				(aLarry setLoop: 1 setCycle: Fwd)
				(aTowers cycleSpeed: 1 setCycle: End self)
			)
			(15
				(aTowers setLoop: 4 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 33)
			)
			(16
				(proc0_5)
				(aLarry setMotion: MoveTo 167 110 self)
			)
			(17
				(gTheMusic number: 4 loop: 1 play:)
				(aLarry setPri: 10 setLoop: 2 cel: 0 setCycle: End self)
			)
			(18
				(aLarry posn: 165 180 setPri: 12 setLoop: 3 cel: 0)
				(= cycles 15)
			)
			(19
				(gTheMusic number: 5 loop: 1 play: self)
			)
			(20
				(proc255_0 610 14)
				(= seconds 3)
			)
			(21
				(proc255_0 610 15)
				(= cycles 11)
			)
			(22 (aLarry setCycle: End self))
			(23
				(proc0_2 aLarry 2 720)
				(aLarry illegalBits: 0)
				(= cycles 22)
			)
			(24
				(proc255_0 610 16)
				(= seconds 2)
			)
			(25 (gEgo setCycle: End self))
			(26
				(proc0_1 3 global66)
				(gEgo illegalBits: 0)
				(proc0_3)
				(= cycles 22)
			)
			(27
				(proc255_0 610 17)
				(proc255_0 610 18)
				(gEgo setMotion: MoveTo 308 183 self)
				(= cycles 11)
			)
			(28
				(aLarry setMotion: MoveTo 276 185 self)
			)
			(29 (gEgo loop: 1))
			(30
				(proc0_20 3)
				(proc0_20 5)
				(proc0_20 4)
				(gGame setSpeed: global101)
				(proc0_1 1)
				(gEgo setPri: 7)
				(aLarry
					setPri: 7
					illegalBits: -32768
					setMotion: Follow gEgo 28
				)
				(proc255_0 610 19)
				(= seconds 2)
			)
			(31
				(proc255_0 610 20)
				(proc255_0 610 21)
				(gTheMusic number: 699 loop: global72 play:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(if (Said 'look>')
			(cond 
				((Said '/door,wall,awning,exit') (proc255_0 610 1))
				((Said '/gravestone') (proc255_0 610 2))
				((Said '[/backdrop,buffet,backstage,area]') (proc255_0 610 3) (proc255_0 610 4 67 -1 144))
			)
		)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(not (& (pEvent modifiers?) emSHIFT))
				(> (pEvent x?) 1)
				(< (pEvent x?) 263)
				(> (pEvent y?) 21)
				(< (pEvent y?) 189)
			)
			(pEvent claimed: 1)
			(switch gCursorNumber
				(998
					(proc255_0 610 3)
					(proc255_0 610 4 67 -1 144)
				)
				(else  (pEvent claimed: 0))
			)
		)
	)
)

(instance atpSign of PV
	(properties
		y 46
		x 285
		view 610
		loop 2
	)
)

(instance atpStencil1 of PV
	(properties
		y 143
		view 610
		loop 2
		cel 1
		priority 15
		signal $4000
	)
)

(instance atpStencil2 of PV
	(properties
		y 142
		x 173
		view 610
		loop 2
		cel 1
		priority 15
		signal $4000
	)
)

(instance atpHouse1 of PV
	(properties
		y 126
		x 91
		view 610
		priority 9
	)
)

(instance atpHouse2 of PV
	(properties
		y 104
		x 5
		view 610
		cel 1
		priority 9
	)
)

(instance atpHouse3 of PV
	(properties
		y 126
		x 41
		view 610
		cel 1
		priority 9
	)
)

(instance atpHouse4 of PV
	(properties
		y 99
		x 57
		view 610
		cel 3
		priority 9
	)
)

(instance atpHouse5 of PV
	(properties
		y 97
		x 95
		view 610
		cel 4
		priority 9
	)
)

(instance atpHouse6 of PV
	(properties
		y 116
		x 128
		view 610
		cel 4
		priority 9
	)
)

(instance atpHouse7 of PV
	(properties
		y 109
		x 123
		view 610
		cel 3
		priority 9
	)
)

(instance aHole of View
	(properties
		y 120
		x 156
		view 610
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setPri: 13 ignoreActors: stopUpd:)
	)
)

(instance aCamera of Act
	(properties
		x 145
		view 616
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: setStep: 1 1)
	)
)

(instance aCar1 of Act
	(properties
		y 129
		x 145
		view 614
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setPri: 9
			setStep: 1 1
			setLoop: 1
			setCycle: Walk
		)
	)
)

(instance aMan1 of Act
	(properties
		y 143
		x 145
		view 613
		cycleSpeed 2
		illegalBits $0000
		moveSpeed 2
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setLoop: 1 setCycle: Walk)
	)
)

(instance aCar2 of Act
	(properties
		y 127
		x 130
		view 614
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setPri: 9
			setStep: 1 1
			setLoop: 2
			setCycle: Walk
		)
	)
)

(instance aMan2 of Act
	(properties
		y 141
		x 130
		view 613
		cycleSpeed 1
		illegalBits $0000
		moveSpeed 1
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors:
			setStep: 2 2
			setLoop: 3
			setCycle: Walk
			setScript: Man2Script
		)
	)
)

(instance Man2Script of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(aCar2 setMotion: MoveTo 88 102)
				(aMan2 setMotion: MoveTo 88 116 self)
			)
			(2
				(aCar2 setMotion: MoveTo 130 127)
				(aMan2 setLoop: 2 setMotion: MoveTo 130 141)
			)
		)
	)
)

(instance aTowers of Prop
	(properties
		y 109
		x 170
		view 610
		loop 3
	)
	
	(method (init)
		(super init:)
		(self setPri: 10 stopUpd: ignoreActors:)
	)
)

(instance aLarry of Act
	(properties)
)
