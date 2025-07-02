;;; Sierra Script 1.0 - (do not remove this comment)
(script# 324)
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
	rm324 0
)

(local
	local0
	local1
)
(instance rm324 of Rm
	(properties
		picture 323
	)
	
	(method (init)
		(Load rsVIEW 327)
		(Load rsVIEW 328)
		(Load rsSOUND 20)
		(Load rsSOUND 8)
		(Load rsSOUND 9)
		(Load rsSOUND 11)
		(Load rsSCRIPT 991)
		(Load rsPIC 99)
		(super init:)
		(gAddToPics add: atpProps doit:)
		(aSuzi init:)
		(aChair init:)
		(aDoorNorth init:)
		(aDoorSouth init:)
		(aPhone init:)
		(aTrapdoor init:)
		(self setScript: RoomScript)
		(= gGNumber_2 11)
		(= global66 708)
		(proc0_1 0)
		(gEgo posn: 41 156 illegalBits: 0 init:)
		(proc0_3)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 2)
		(switch (= state newState)
			(0 (= cycles 22))
			(1
				(proc255_0 324 0)
				(= seconds 3)
			)
			(2
				(proc255_0 324 1)
				(proc255_0 324 2 67 -1 144)
				(= seconds 3)
			)
			(3
				(proc255_0 324 3)
				(= seconds 3)
			)
			(4
				(proc255_0 324 4)
				(gEgo
					ignoreActors:
					illegalBits: 0
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo (+ 40 (gEgo x?)) (gEgo y?) self
				)
			)
			(5
				(gEgo setMotion: MoveTo 115 134 self)
			)
			(6
				(proc255_0 324 5)
				(gEgo loop: 2)
				(aSuzi
					view: 327
					setPri: -1
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 232 125 self
				)
				(aChair view: 329 posn: 247 133 setLoop: 3 stopUpd:)
			)
			(7
				(aSuzi setMotion: MoveTo 190 125 self)
			)
			(8
				(proc255_0 324 6)
				(aSuzi setMotion: MoveTo 190 141 self)
			)
			(9
				(aSuzi setMotion: MoveTo 47 156 self)
				(= cycles 27)
			)
			(10 (proc255_0 324 7))
			(11
				(aDoorNorth setCycle: Beg)
				(aDoorSouth setCycle: Beg self)
				(gTheMusic fade:)
			)
			(12
				(gTheSoundFX number: 11 loop: 1 play:)
				(aDoorNorth stopUpd:)
				(aDoorSouth stopUpd:)
				(proc255_0 324 8)
				(aSuzi setMotion: MoveTo (+ 15 (gEgo x?)) 156 self)
			)
			(13
				(proc255_0 324 9)
				(aSuzi setMotion: MoveTo 148 133 self)
			)
			(14
				(proc255_0 324 10)
				(gEgo
					cycleSpeed: 1
					setPri: 8
					view: 322
					cel: 0
					setCycle: End self
				)
				(aSuzi loop: 1)
				(gAddToPics add: atpHat doit:)
			)
			(15
				(proc255_0 324 11)
				(= seconds 3)
			)
			(16
				(aSuzi
					cycleSpeed: 2
					view: 328
					setLoop: 0
					cel: 0
					setCycle: End self
				)
				(gTheMusic number: 8 loop: -1 play:)
			)
			(17 (= seconds 3))
			(18
				(proc255_0 324 12)
				(= seconds 3)
			)
			(19
				(proc255_0 324 13)
				(= seconds 3)
			)
			(20
				(proc255_0 324 14)
				(proc0_19 45)
				(gGame changeScore: 100)
				(aSuzi hide:)
				(gEgo
					view: 328
					setLoop: 2
					setCel: 0
					cycleSpeed: 3
					posn: 123 118
				)
				(gAddToPics add: atpSuziClothes doit:)
				(= cycles 22)
			)
			(21 (gEgo setCycle: End self))
			(22 (= seconds 3))
			(23 (gEgo setCycle: Beg self))
			(24
				(gEgo
					viewer: humpCycler
					posn: 123 118
					setLoop: 3
					setCycle: Fwd
				)
				(= cycles 0)
				(= seconds 3)
			)
			(25
				(if (> (++ local1) 1)
					(self cue:)
				else
					(aTrapdoor setMotion: MoveTo 152 6 self)
				)
			)
			(26
				(gTheMusic stop:)
				(gTheSoundFX number: 20 loop: -1 play:)
				(aPhone
					view: 323
					setPri: 13
					setStep: 1 1
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 146 6 self
				)
			)
			(27
				(gEgo viewer: 0 setCel: 0)
				(if (== local1 1) (proc255_0 324 15))
				(= seconds 3)
			)
			(28
				(switch local1
					(1 (proc255_0 324 16))
					(2
						(proc255_0 324 17)
						(proc255_0 324 18 67 -1 144)
					)
					(3 (proc255_0 324 19))
					(4
						(proc255_4 324 20 global170)
						(proc255_0 324 21 67 -1 144)
					)
				)
				(= cycles 12)
			)
			(29
				(aSuzi
					cycleSpeed: 0
					setLoop: 4
					cel: 0
					posn: 133 117
					setPri: 9
					setCycle: End self
					show:
				)
			)
			(30
				(aSuzi setLoop: 5 cel: 0 setCycle: End self)
				(aPhone setLoop: 6 setCel: 1 stopUpd:)
				(gTheSoundFX stop:)
				(= local0 0)
			)
			(31
				(aSuzi setLoop: 6 setCycle: Fwd)
				(if (== local1 4)
					(self changeState: 51)
				else
					(= cycles (Random 11 33))
				)
			)
			(32
				(aSuzi setCel: 1)
				(= cycles (Random 5 11))
				(if (> 3 (++ local0)) (= state 30))
			)
			(33
				(aSuzi setLoop: 5 setCel: 255 setCycle: Beg self)
			)
			(34
				(proc255_0 324 22)
				(aPhone setCel: 0 stopUpd:)
				(if (== local1 1)
					(aPhone setMotion: MoveTo (aPhone x?) -111)
				)
				(aSuzi setLoop: 4 setCel: 255 setCycle: Beg self)
				(gTheMusic number: 8 loop: -1 play:)
			)
			(35
				(aSuzi hide:)
				(gEgo viewer: humpCycler setCycle: Fwd)
				(= seconds 2)
			)
			(36
				(switch local1
					(1
						(proc255_0 324 23)
						(self changeState: 24)
					)
					(2
						(proc255_0 324 24)
						(proc255_0 324 25 67 -1 144)
					)
					(3 (proc255_0 324 26))
				)
				(= seconds 2)
			)
			(37
				(gEgo viewer: 0 setCel: 0)
				(aSuzi setLoop: 4 cel: 0 setCycle: End self show:)
			)
			(38
				(aSuzi setLoop: 7 cel: 0 setCycle: End self)
				(aPhone setCel: 2 stopUpd:)
			)
			(39
				(aSuzi setLoop: 8 setCycle: Fwd)
				(= seconds 4)
			)
			(40
				(aSuzi setLoop: 7 setCel: 255 setCycle: Beg self)
			)
			(41
				(aSuzi setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(42
				(proc255_0 324 27)
				(aPhone
					setLoop: 6
					setCel: 0
					setMotion: MoveTo (aPhone x?) -111
				)
				(if (< local1 3)
					(self changeState: 24)
				else
					(= seconds 2)
				)
			)
			(43
				(proc255_0 324 28)
				(= seconds 3)
			)
			(44
				(aSuzi setLoop: 9 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(45
				(gEgo viewer: humpCycler setCycle: Fwd)
				(aSuzi
					view: 323
					setLoop: 5
					setCel: 0
					posn: 141 102
					setPri: 15
					setStep: 4 4
					setMotion: MoveTo 215 74 self
				)
			)
			(46
				(aSuzi setCel: 1 setMotion: JumpTo 289 121 self)
			)
			(47
				(aSuzi
					setCel: 2
					setStep: 5 5
					setMotion: MoveTo 221 189 self
				)
			)
			(48
				(aSuzi setMotion: MoveTo 177 233 self)
			)
			(49 (= seconds 2))
			(50
				(aSuzi
					view: 328
					setLoop: 4
					cel: 0
					posn: 133 117
					setPri: 9
					hide:
				)
				(= seconds 2)
				(= state 23)
			)
			(51
				(proc255_0 324 29)
				(proc255_0 324 30)
				(gTheMusic number: 9 loop: 1 play:)
				(= global99 6)
				(= cycles 22)
			)
			(52
				(global2 drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= cycles 22)
			)
			(53
				(proc255_0 324 31)
				(proc255_0 324 32)
				(global2 newRoom: 320)
			)
		)
	)
)

(instance atpProps of PV
	(properties
		y 132
		x 240
		view 329
		loop 4
		priority 10
		signal $4000
	)
)

(instance atpHat of PV
	(properties
		y 138
		x 115
		view 328
		loop 1
		priority 14
		signal $4000
	)
)

(instance atpSuziClothes of PV
	(properties
		y 133
		x 148
		view 323
		loop 7
		priority 14
		signal $4000
	)
)

(instance aChair of Prop
	(properties
		y 133
		x 247
		view 329
		loop 2
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self setPri: 4 stopUpd:)
	)
)

(instance aSuzi of Act
	(properties
		y 120
		x 242
		view 324
		loop 1
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setPri: 13
			stopUpd:
		)
	)
)

(instance aPhone of Act
	(properties
		y -111
		x 146
		view 323
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			setLoop: 3
			setPri: 13
			setStep: 1 1
			setCycle: Fwd
		)
	)
)

(instance aTrapdoor of Act
	(properties
		y -4
		x 152
		view 323
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			setLoop: 4
			setPri: 5
			setStep: 1 1
		)
	)
)

(instance aDoorSouth of Prop
	(properties
		y 103
		x 20
		view 323
	)
	
	(method (init)
		(super init:)
		(self setCel: 255 setPri: 13 ignoreActors: stopUpd:)
	)
)

(instance aDoorNorth of Prop
	(properties
		y 95
		x 41
		view 323
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setCel: 255 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance humpCycler of Code
	(properties)
	
	(method (doit)
		(if (not (Random 0 9))
			(gEgo cycleSpeed: (Random 0 5))
		)
	)
)
