;;; Sierra Script 1.0 - (do not remove this comment)
(script# 45)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Obj)

(public
	LockerScript 0
)

(local
	[local0 20]
	[local20 20]
	[local40 20]
)
(instance LockerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(if (proc0_22 44)
					(self cue:)
				else
					(gGame changeScore: 65)
					(proc255_0 45 0 82 9 0 1)
					(= seconds 2)
				)
			)
			(1
				(if (proc0_22 44)
					(Format @local0 45 1 46 global111)
					(Format @local20 45 1 46 global112)
					(Format @local40 45 1 46 global113)
					(proc255_4 45 2 @local0 @local20 @local40)
				else
					(proc0_19 44)
					(Format @local0 45 1 46 (= global111 0))
					(while (== 32 (StrAt @local0 0))
						(= global111 (Random 1 24))
						(Format @local0 45 1 46 global111)
					)
					(= global112 global111)
					(while
						(or
							(== global111 global112)
							(== 32 (StrAt @local20 0))
						)
						(= global112 (Random 1 24))
						(Format @local20 45 1 46 global112)
					)
					(= global113 global111)
					(while
						(or
							(== global111 global113)
							(== global112 global113)
							(== 32 (StrAt @local40 0))
						)
						(= global113 (Random 1 24))
						(Format @local40 45 1 46 global113)
					)
					(proc255_4 45 3 @local0 @local20 @local40)
				)
				(proc0_4)
				(gGame setScript: 0)
				(DisposeScript 45)
				(DisposeScript 46)
			)
		)
	)
)
