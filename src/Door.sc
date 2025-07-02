;;; Sierra Script 1.0 - (do not remove this comment)
(script# 50)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Feature)


(class Door of Prop
	(properties
		y 0
		x 0
		z 0
		heading 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		cycleSpeed 1
		script 0
		cycler 0
		timer 0
		entranceTo 0
		locked 0
		openSnd 0
		closeSnd 0
		doorState 0
		doorCtrl 2
		roomCtrl 4
		doorBlock 16384
		code 0
		illegalBits $0000
		force 0
		notify 0
	)
	
	(method (init)
		(if (and gGNumber (== gGNumber entranceTo))
			(= doorState 2)
		)
		(if (== doorState 0)
			(= cel 0)
			(gEgo observeControl: doorBlock)
		else
			(= cel (- (NumCels self) 1))
			(= locked 0)
			(gEgo ignoreControl: doorBlock)
		)
		(super init:)
		(self stopUpd: ignoreActors:)
	)
	
	(method (doit)
		(super doit:)
		(if (!= doorState 2)
			(gEgo observeControl: doorBlock)
		else
			(gEgo ignoreControl: doorBlock)
		)
		(if
		(and roomCtrl entranceTo (& (gEgo onControl:) roomCtrl))
			(global2 newRoom: entranceTo)
		)
	)
	
	(method (cue)
		(= doorState (if (== doorState 3) 0 else 2))
		(if (== doorState 2)
			(gEgo ignoreControl: doorBlock)
		else
			(gEgo observeControl: doorBlock)
		)
		(self stopUpd:)
		(if notify (notify cue:) (= notify 0))
	)
	
	(method (open)
		(cond 
			(
			(and (not force) (!= (gEgo onControl: 1) doorCtrl)) (proc0_10))
			(locked (proc255_0 50 0))
			((or (== doorState 1) (== doorState 2)) (proc0_7))
			(else
				(= doorState 1)
				(self setCycle: End self)
				(if openSnd (openSnd play:))
			)
		)
	)
	
	(method (close)
		(cond 
			(
			(and (not force) (!= (gEgo onControl: 1) doorCtrl)) (proc0_10))
			(locked (proc255_0 50 0))
			((or (== doorState 3) (== doorState 0)) (proc0_7))
			((& (gEgo onControl:) doorBlock)
				(if (> global88 1)
					(proc255_0 50 1)
				else
					(proc255_0 50 2)
				)
			)
			(else
				(= doorState 3)
				(self setCycle: Beg self)
				(if closeSnd (closeSnd play:))
			)
		)
	)
)
