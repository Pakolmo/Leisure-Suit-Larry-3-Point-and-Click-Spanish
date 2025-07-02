;;; Sierra Script 1.0 - (do not remove this comment)
(script# 525)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Jump)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm525 0
)

(local
	[local0 40]
	[local40 22]
)
(instance rm525 of Rm
	(properties
		picture 525
		horizon 1
	)
	
	(method (init)
		(Load rsVIEW 525)
		(Load rsSOUND 3)
		(Load rsSOUND 526)
		(Load rsSOUND 527)
		(Load rsSOUND 4)
		(proc0_3)
		(proc0_5)
		(= global101 (gGame setSpeed: 6))
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(gEgo
			view: 525
			setLoop: (if (== gGNumber_2 2) 4 else 0)
			setCel: 0
			setStep: 0 7
			setMotion: 0
			setCycle: (if (== gGNumber_2 2) Fwd else 0)
			posn: 142 13
			cycleSpeed: 1
			illegalBits: 0
			ignoreActors:
			init:
			put: 15 -1
		)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gGNumber_2 2)
					(= cycles 10)
				else
					(gTheMusic number: 4 loop: 1 play:)
					(gEgo setMotion: MoveTo 144 18 self)
					(= state 19)
				)
			)
			(1
				(proc255_0 525 0)
				(proc255_0 525 1 67 -1 144)
				(= cycles 20)
			)
			(2
				(gTheMusic stop: number: 3 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3 (gEgo setCycle: Beg self))
			(4
				(gTheMusic stop: number: 526 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6 (gEgo setCycle: Beg self))
			(7
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(8
				(gTheMusic stop: number: 527 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(10
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(11 (gEgo setCycle: Beg self))
			(12
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(13
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(14
				(gTheMusic stop: number: 527 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(15
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(16
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(17
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(18
				(gEgo setLoop: 4 setPri: -1 posn: 143 114 setCycle: Fwd)
				(aHose ignoreActors: init:)
				(proc255_0 525 2 67 -1 10 83)
				(gTheMusic stop: number: 4 loop: 1 play:)
				(global2 newRoom: 530)
			)
			(20
				(gEgo setMotion: theJump self)
			)
			(21
				(proc255_0 525 3)
				(gEgo hide:)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 814
					register: (Format @local0 525 4)
					next: (Format @local40 525 5)
				)
			)
		)
	)
)

(instance aHose of Prop
	(properties
		y 13
		x 142
		view 525
		loop 5
	)
)

(instance theJump of Jump
	(properties)
	
	(method (init)
		(super init: gEgo RoomScript)
		(self yStep: 1 y: 183)
	)
)
