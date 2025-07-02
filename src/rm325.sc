;;; Sierra Script 1.0 - (do not remove this comment)
(script# 325)
(include sci.sh)
(use Main)
(use rm71)
(use Class_255_0)
(use Game)
(use Obj)

(public
	rm325 0
)

(instance rm325 of Rm
	(properties
		picture 325
	)
	
	(method (init)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript)
		(proc0_13 71 1 103 63)
		(proc0_13 71 2 184 60)
		(proc0_13 71 3 106 65)
		(proc0_13 71 4 181 65)
		(proc0_13 71 5 143 107)
		(proc0_13 71 6 141 152)
		(proc0_3)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 11))
			(1
				(proc71_1 2 20)
				(= cycles 33)
			)
			(2
				(proc255_0 325 0)
				(= cycles 11)
			)
			(3 (global2 newRoom: 323))
		)
	)
)
