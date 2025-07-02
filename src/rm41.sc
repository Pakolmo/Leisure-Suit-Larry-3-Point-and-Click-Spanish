;;; Sierra Script 1.0 - (do not remove this comment)
(script# 41)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Jump)
(use Cycle)
(use Game)
(use Obj)

(public
	rm41 0
)

(local
	local0
	local1
	gEgoX
	gEgoY
	[local4 44]
	[local48 22]
)
(instance rm41 of Rgn
	(properties)
	
	(method (init)
		(Load rsSOUND 4)
		(if global108 (Load rsVIEW 813) else (Load rsVIEW 713))
		(super init:)
		(self setScript: FallScript)
	)
	
	(method (notify param1 param2)
		(= local0 param1)
		(= local1 param2)
		(FallScript changeState: 1)
	)
)

(instance FallScript of Script
	(properties)
	
	(method (doit)
		(if (and global64 (== gGNumber_2 0))
			(= gEgoX (gEgo x?))
			(= gEgoY (gEgo y?))
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(gTheSoundFX number: 4 loop: 1 play:)
				(proc255_0 (Format @local4 41 0 global170) 67 -1 10 88)
				(= gGNumber_2 2)
				(gEgo
					view: (if global108 813 else 713)
					setLoop: 0
					cel: 0
					illegalBits: 0
					ignoreActors:
					setPri: local0
					setCycle: End self
				)
			)
			(2 (gEgo setMotion: theJump))
			(3
				(proc0_5)
				(if global64
					(proc0_1)
					(= gGNumber_2 0)
					(gEgo posn: gEgoX gEgoY)
				else
					(gGame setScript: (ScriptID 40))
					((ScriptID 40)
						caller: (+ 1 (gEgo view?))
						register: (Format @local4 41 1 global82)
						next: (Format @local48 41 2)
					)
				)
			)
		)
	)
)

(instance theJump of Jump
	(properties)
	
	(method (init)
		(super init: gEgo FallScript)
		(self yStep: 5 y: local1)
	)
)
