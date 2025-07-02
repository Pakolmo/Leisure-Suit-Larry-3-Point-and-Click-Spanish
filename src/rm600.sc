;;; Sierra Script 1.0 - (do not remove this comment)
(script# 600)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Obj)

(public
	rm600 0
)

(instance rm600 of Rm
	(properties
		picture 99
	)
	
	(method (init)
		(proc0_3)
		(proc0_19 3)
		(proc0_19 5)
		(proc0_19 4)
		(gTheMusic number: 600 loop: -1 play:)
		(super init:)
		(= global101 (gGame setSpeed: 3))
		(gEgo view: 601 setLoop: 1 setStep: 22 12 init:)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(gEgo
			posn: (Random 10 310) -40
			setMotion: MoveTo (Random 10 310) 224 RoomScript
		)
		(switch (= state newState)
			(2 (proc255_4 600 0 global170))
			(4 (proc255_0 600 1))
			(5 (gEgo setLoop: 0))
			(8 (proc255_0 600 2))
			(9 (proc255_0 600 3))
			(10
				(gGame setSpeed: global101)
				(gTheMusic fade:)
				(global2 newRoom: 610)
			)
		)
	)
)
